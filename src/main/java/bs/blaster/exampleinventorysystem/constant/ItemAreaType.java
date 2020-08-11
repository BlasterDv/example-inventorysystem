package bs.blaster.exampleinventorysystem.constant;

public enum ItemAreaType {
    DEFAULT(0.0f, 0.0f);


    private float modelOffset;
    private float areaOffset;
    private int timeDestroy;

    private ItemAreaType(float modelOffset, float areaOffset) {
        this.modelOffset = modelOffset;
        this.areaOffset = areaOffset;
    }
}
