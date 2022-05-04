package chess.dto;

import chess.domain.chessboard.ChessBoard;
import chess.domain.piece.Piece;
import chess.domain.position.Position;
import chess.entity.Square;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BoardDto {

    private Map<String, PieceDto> board;

    public BoardDto(Map<String, PieceDto> board) {
        this.board = board;
    }

    public static BoardDto of(List<Square> board) {
        Map<String, PieceDto> newBoard = board.stream()
                .collect(Collectors.toMap(Square::getPosition,
                        square -> PieceDto.from(Piece.of(square.getColor(), square.getSymbol()))));
        return new BoardDto(newBoard);
    }

    public static BoardDto from(ChessBoard chessBoard) {
        Map<Position, Piece> pieces = chessBoard.getPieces();
        Map<String, PieceDto> board = pieces.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getValue(),
                        entry -> PieceDto.from(entry.getValue())));
        return new BoardDto(board);
    }

    public ChessBoard toBoard() {
        Map<Position, Piece> pieces = this.board.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> Position.of(
                                entry.getKey()), entry -> entry.getValue().toPiece()));
        return new ChessBoard(pieces);
    }

    public Map<String, PieceDto> getBoard() {
        return board;
    }
}
