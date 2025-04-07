package oliveiradev.pets.DearPet.models.enums;

public enum Castrado {
    SIM(1),
    NAO(0);

    private int castrado;

    Castrado(int castrado) {
        this.castrado = castrado;
    }

    public int getCastrado() {
        return castrado;
    }

    public void setCastrado(int castrado) {
        this.castrado = castrado;
    }
}