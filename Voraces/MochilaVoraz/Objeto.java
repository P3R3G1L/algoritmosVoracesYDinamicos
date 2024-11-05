package MochilaVoraz;

public class Objeto {

    private double peso;
    private double valor;
    private double porcentaje;

    public Objeto(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
        this.porcentaje = 1;
    }

    public double getPeso() {
        return peso * porcentaje;
    }

    public double getValor() {
        return valor * porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getValorPorPeso() {
        return (double) (valor/peso) * porcentaje;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "peso=" + getPeso() +
                ", valor=" + getValor() +
                ", porcentaje=" + porcentaje +
                '}';
    }
}
