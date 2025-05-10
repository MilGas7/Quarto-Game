package am.aua.quarto.oi.gui;

import am.aua.quarto.core.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.*;

/**
 * Abstract base class for Quarto GUI implementations.
 */
public abstract class BaseQuartoGUI extends JFrame {
    protected JLabel statusLabel;   // Displays current player's turn
    protected JLabel messageLabel;  // Displays game messages
    protected JPanel boardPanel;
    protected JButton[] tileButtons = new JButton[Board.SIZE * Board.SIZE];
    protected JButton[] pieceButtons = new JButton[16];
    protected BlockingQueue<String> inputQueue = new LinkedBlockingQueue<>();
    protected ImageIcon[] pieceIcons = new ImageIcon[16];
    protected int selectedPieceIndex = -1;

    /**
     * Constructs the GUI frame and initializes the board, piece icons,
     * and UI components.
     */
    public BaseQuartoGUI() {
        setTitle("Quarto Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initializePieceIcons();

        JPanel topPanel = new JPanel(new GridLayout(2, 1));

        statusLabel = new JLabel("Player 1's Turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        topPanel.add(statusLabel);

        messageLabel = new JLabel("Welcome to Quarto", SwingConstants.CENTER);
        messageLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        topPanel.add(messageLabel);

        add(topPanel, BorderLayout.NORTH);

        boardPanel = new JPanel(new GridLayout(Board.SIZE, Board.SIZE));
        for (int i = 0; i < tileButtons.length; i++) {
            JButton btn = new JButton();
            final int index = i;
            btn.addActionListener(e -> inputQueue.offer((index / Board.SIZE) + " " + (index % Board.SIZE)));
            tileButtons[i] = btn;
            boardPanel.add(btn);
        }
        add(boardPanel, BorderLayout.CENTER);

        JPanel piecePanel = new JPanel(new GridLayout(2, 8));
        for (int i = 0; i < 16; i++) {
            JButton btn = new JButton(pieceIcons[i]);
            final int piece = i;
            btn.addActionListener(e -> {
                selectedPieceIndex = piece;
                inputQueue.offer(Integer.toString(piece));
                highlightSelectedPiece();  // call to refresh UI
            });
            pieceButtons[i] = btn;
            piecePanel.add(btn);
        }
        add(piecePanel, BorderLayout.SOUTH);

        setSize(800, 600);
        setVisible(true);
    }

    /**
     * Sets and visually highlights the selected piece.
     *
     * @param pieceIndex index of the selected piece (0–15)
     */
    public void setSelectedPiece(int pieceIndex) {
        this.selectedPieceIndex = pieceIndex;
        highlightSelectedPiece();
    }

    /**
     * Highlights the selected piece in the GUI.
     */
    private void highlightSelectedPiece() {
        for (int i = 0; i < pieceButtons.length; i++) {
            if (i == selectedPieceIndex) {
                pieceButtons[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
            } else {
                pieceButtons[i].setBorder(UIManager.getBorder("Button.border"));
            }
        }
    }

    /**
     * Initializes visual icons for all 16 pieces using their traits.
     */
    private void initializePieceIcons() {
        for (int i = 0; i < 16; i++) {
            pieceIcons[i] = createPieceIcon(Piece.makePiece(i));
        }
    }

    /**
     * Creates an icon for a given piece.
     *
     * @param piece the piece to visualize
     * @return an ImageIcon representation of the piece
     */
    private ImageIcon createPieceIcon(Piece piece) {
        int iconSize = 60;
        BufferedImage image = new BufferedImage(iconSize, iconSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        boolean isBig = (piece.getSize() == Piece.Size.BIG);
        boolean isSquare = (piece.getShape() == Piece.Shape.SQUARE);
        boolean isHollow = (piece.getHole() == Piece.Hole.HOLLOW);
        boolean isBlack = (piece.getColor() == Piece.Color.BLACK);

        Color fillColor = isBlack ? Color.BLACK : Color.WHITE;
        Color outlineColor = isBlack ? Color.BLACK : Color.WHITE;
        Color backgroundColor = new Color(0, 0, 0, 0);

        g2d.setBackground(backgroundColor);
        g2d.clearRect(0, 0, iconSize, iconSize);

        int baseSize = 30;
        int shapeSize = isBig ? (int) (baseSize * 1.4) : baseSize;
        int x = (iconSize - shapeSize) / 2;
        int y = (iconSize - shapeSize) / 2;

        g2d.setStroke(new BasicStroke(10));

        if (isHollow) {
            g2d.setColor(outlineColor);
            if (isSquare) {
                g2d.drawRect(x, y, shapeSize, shapeSize);
            } else {
                g2d.drawOval(x, y, shapeSize, shapeSize);
            }
        } else {
            // Filled pieces
            g2d.setColor(fillColor);
            if (isSquare) {
                g2d.fillRect(x, y, shapeSize, shapeSize);
                g2d.setColor(outlineColor);
                g2d.drawRect(x, y, shapeSize, shapeSize);
            } else {
                g2d.fillOval(x, y, shapeSize, shapeSize);
                g2d.setColor(outlineColor);
                g2d.drawOval(x, y, shapeSize, shapeSize);
            }
        }

        g2d.dispose();
        return new ImageIcon(image);
    }

    /**
     * Updates the message and status labels on the UI.
     *
     * @param message the message to display
     */
    public void updateMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            if (message.startsWith("Current player is PLAYER")) {
                statusLabel.setText(message);
            } else {
                messageLabel.setText(message);
            }
        });
    }

    /**
     * Updates the entire board and piece panel based on the current state.
     *
     * @param board the board to reflect on the GUI
     */
    public void updateBoard(Board board) {
        SwingUtilities.invokeLater(() -> {
            for (int i = 0; i < tileButtons.length; i++) {
                Piece p = board.getTile(i);
                if (p != null) {
                    ImageIcon icon = pieceIcons[Piece.toInt(p)];
                    tileButtons[i].setIcon(icon);
                    tileButtons[i].setDisabledIcon(icon);
                    tileButtons[i].setEnabled(false);
                    tileButtons[i].setBackground(new Color(230, 230, 230));
                    tileButtons[i].setOpaque(true);
                } else {
                    tileButtons[i].setIcon(null);
                    tileButtons[i].setEnabled(true);
                    tileButtons[i].setBackground(null);
                    tileButtons[i].setOpaque(false);
                }
                tileButtons[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }

            for (int i = 0; i < pieceButtons.length; i++) {
                pieceButtons[i].setEnabled(!board.getPieceCount(i));

            }
            boolean allPiecesUsed = true;
            for (int i = 0; i < 16; i++) {
                if (!board.getPieceCount(i)) {
                    allPiecesUsed = false;
                    break;
                }
            }

            if (!allPiecesUsed) {
                selectedPieceIndex = -1;
                highlightSelectedPiece();
            }

        });
    }

    /**
     * Waits for and returns the next input from the user.
     *
     * @param prompt the message to display before waiting
     */
    public String getInput(String prompt) {
        updateMessage(prompt);
        try {
            return inputQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "";
        }
    }

    /**
     * Displays a dialog at the end of the game with options to restart or exit.
     *
     * @param message   the message to show (e.g., "Player 1 wins!")
     * @param onNewGame action to run if user chooses to restart
     */
    protected void showEndGameDialog(String message, Runnable onNewGame) {
        SwingUtilities.invokeLater(() -> {
            JDialog dialog = new JDialog(this, "Game Over", true);
            dialog.setLayout(new BorderLayout());
            dialog.setSize(300, 150);
            dialog.setLocationRelativeTo(this);

            JLabel msgLabel = new JLabel(message, SwingConstants.CENTER);
            msgLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
            dialog.add(msgLabel, BorderLayout.CENTER);

            JPanel buttons = new JPanel();
            JButton newGameBtn = new JButton("Start new");
            JButton exitBtn = new JButton("Exit");

            newGameBtn.addActionListener(e -> {
                dialog.dispose();
                onNewGame.run();
            });

            exitBtn.addActionListener(e -> System.exit(0));

            buttons.add(newGameBtn);
            buttons.add(exitBtn);
            dialog.add(buttons, BorderLayout.SOUTH);

            dialog.setVisible(true);
        });
    }

}