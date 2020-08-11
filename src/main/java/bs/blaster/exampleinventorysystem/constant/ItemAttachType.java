package bs.blaster.exampleinventorysystem.constant;

public enum ItemAttachType {
    None(0, false);

    private int slotAttach;
    private boolean useAnimCarry;

    private ItemAttachType(int slotAttach, boolean useAnimCarry) {
        this.slotAttach = slotAttach;
        this.useAnimCarry = useAnimCarry;
    }
}
