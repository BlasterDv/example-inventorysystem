package bs.blaster.exampleinventorysystem.constant;

import net.gtaun.shoebill.data.Vector3D;

public class ItemOffset {

    private static final ItemOffset[] itemOffset =
            {
                    new ItemOffset(new Vector3D(-18.000000f, 0.000000f, -50.000000f), 0.8f, 0.0f, 0.0f, 0.0f),
                    new ItemOffset(new Vector3D(0.0f, -90.0f, 90.0f), 0.8f, 0.0f, -90.0f, 0.0f),
                    new ItemOffset(new Vector3D(-18.0f, 0.0f, -50.0f), 0.8f, 90.0f, 0.0f, 0.0f),
                    new ItemOffset(new Vector3D(-18.0f, 0.0f, -90.0f), 1.0f, 0.0f, 0.0f, 1.0f),
                    new ItemOffset(new Vector3D(-18.0f, 0.0f, -50.0f), 0.8f, 0.0f, -90.0f, -10.0f),
                    new ItemOffset(new Vector3D(0.0f, 0.0f, 40.0f), 1.0f, 0.0f, 0.0f, 0.0f),
                    new ItemOffset(new Vector3D(0.0f, 0.0f, 0.0f), 0.0f, 0.0f, 0.0f, 0.0f),
                    new ItemOffset(new Vector3D(-10.0f, 0.0f, 180.0f), 0.8f, 0.0f, 0.0f, 0.0f)
            };

    private Vector3D rot;
    private float zoom;
    private double fX;
    private double fY;
    private double fZ;


    private ItemOffset(Vector3D rotation, float zoom, float fX, float fY, float fZ)
    {
        this.rot = rotation;
        this.zoom = zoom;
        this.fX = fX;
        this.fY = fY;
        this.fZ = fZ;
    }

    private ItemOffset get(int point)
    {
        return itemOffset[point];
    }
}
