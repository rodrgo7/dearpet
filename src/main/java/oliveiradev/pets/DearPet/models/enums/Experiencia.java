package oliveiradev.pets.DearPet.models.enums;

public enum Experiencia {
    JUNIOR(1),
    PLENO(2),
    SENIOR(3);

    private int experiencia;

    Experiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
}