public class CapturedPokemon extends Pokemon {
    private boolean isKnocked;
    public CapturedPokemon(String name, String type, int totalStats, String state) {
        super(name, type, totalStats);
        setCombatState(state);

    }

    public void setCombatState(String state) {
        if (state.equals("Vivo"))
        {
            this.isKnocked = false;
        }

        else if (state.equals("Debilitado"))
        {
            this.isKnocked = true;
        }

        else
        {
            System.out.println("Estado desconocido");
        }

    }

    public String getCombatState()
    {
        return (isKnocked) ? "Debilitado" : "Vivo";
    }
}
