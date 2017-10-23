package calc.operations;

public interface Operation {
    double exec(double a, double b);
    EnumOperation getEnumOperation();
}
