package chess.dto;

public class SquareDto {

    private String position;
    private String symbol;
    private String color;

    public SquareDto(String position, String symbol, String color) {
        this.position = position;
        this.symbol = symbol;
        this.color = color;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }

    public String getPosition() {
        return position;
    }
}
