package bs.blaster.exampleinventorysystem;

import bs.blaster.exampleinventorysystem.constant.Item;
import net.gtaun.shoebill.constant.TextDrawAlign;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.data.Vector2D;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.PlayerTextdraw;

import java.util.Map;

public class InventoryPanel {

    private Player player;

    protected InventoryPanel(Player player ) {
        this.player = player;

    }

    public void show(Map<Integer, ItemModel> items)
    {
        for(Map.Entry<Integer, ItemModel> s :  items.entrySet()) {
            InventorySystemPlugin.getInstance().InventoryPreviewItem[s.getKey()].setPreviewModel(s.getValue().getItem());
            InventorySystemPlugin.getInstance().InventoryPreviewItem[s.getKey()].show(player);

        }
        for(int i = 0; i < Item.MaxInventoryItem; i++) {
            InventorySystemPlugin.getInstance().InventoryPreviewBox[i].show(player);
        }

        for(int i = 0; i < Item.MaxEquipedItems; i++) {
            InventorySystemPlugin.getInstance().InventoryPreviewBox[i + 12].show(player);
        }
    }

    private void Inventory_AddTextdrawInfo(Player player, float posy)
    {
        posy = 164.0f;
        float sizex = 40.0f;

        CreatePlayerInvTextdrawEx(player, 0, 151.0f + (0 * (sizex + 1.0f)), posy, sizex, 43.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 1, 151.0f + (1 * (sizex + 1.0f)), posy, sizex, 43.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 2, 151.0f + (2 * (sizex + 1.0f)), posy, sizex, 43.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 3, 151.0f + (0 * (sizex + 1.0f)), posy + 44.0f, sizex, 43.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 4, 151.0f + (1 * (sizex + 1.0f)), posy + 44.0f, sizex, 43.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 5, 151.0f + (2 * (sizex + 1.0f)), posy + 44.0f, sizex, 43.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 6, 151.0f + (0 * (sizex + 1.0f)), posy + 88.0f, sizex, 43.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 7, 151.0f + (1 * (sizex + 1.0f)), posy + 88.0f, sizex, 43.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 8, 151.0f + (2 * (sizex + 1.0f)), posy + 88.0f, sizex, 43.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 9, 151.0f + (0 * (sizex + 1.0f)), posy + 132.0f, sizex, 43.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 10, 151.0f + (1 * (sizex + 1.0f)), posy + 132.0f, sizex, 43.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 11, 151.0f + (2 * (sizex + 1.0f)), posy + 132.0f, sizex, 43.0f, 0, true);

        CreatePlayerInvTextdrawEx(player, 12, 295.0f + (0 * 28.0f), 310.0f, 27.0f, 31.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 13, 295.0f + (1 * 28.0f), 310.0f, 27.0f, 31.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 14, 295.0f + (2 * 28.0f), 310.0f, 27.0f, 31.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 15, 295.0f + (3 * 28.0f), 310.0f, 27.0f, 31.0f, 0, true);
        CreatePlayerInvTextdrawEx(player, 16, 295.0f + (4 * 28.0f), 310.0f, 27.0f, 31.0f, 0, true);
    }

    private void CreatePlayerInvTextdrawEx(Player player, int slot, float tx, float ty, float sizex, float sizey, int type, boolean create)
    {
        PlayerTextdraw textdrawid = PlayerTextdraw.create(player, new Vector2D(tx + 40.0f, ty + 40.0f), "_");
        textdrawid.setAlignment(TextDrawAlign.RIGHT);
        textdrawid.setColor(new Color(0xECECECFF));
        textdrawid.setLetterSize(new Vector2D(0.20f, 1.0f));
        textdrawid.setTextSize(new Vector2D(sizex, sizey));
        textdrawid.setBackgroundColor(new Color(0x00000088));
        textdrawid.setOutlineSize(1);
        textdrawid.show();
    }

}
