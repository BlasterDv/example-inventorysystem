package bs.blaster.exampleinventorysystem;

import net.gtaun.shoebill.constant.TextDrawAlign;
import net.gtaun.shoebill.constant.TextDrawFont;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.data.Vector2D;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.PlayerTextdraw;

import java.util.Map;

public class PlayerPanel {

    private Player player;

    private PlayerTextdraw Close;

    private InventoryPanel inventoryPanel;

    public PlayerPanel(Player player)
    {
        this.player = player;


    }

    public void setClose(boolean small)
    {
        Vector2D position;
        if (small == true) position = new Vector2D(434.0f, 120.0f);
        else position = new Vector2D(452.0f, 120.0f);

        if(Close != null)
        {
            Close.destroy();
        }
        Close = PlayerTextdraw.create(player, position, "X");
        Close.setFont(TextDrawFont.FONT2);
        Close.setLetterSize(new Vector2D(0.29f, 1.20f));
        Close.setColor(new Color(-1));
        Close.setAlignment(TextDrawAlign.CENTER);
        Close.setTextSize(new Vector2D(10.0f, 11.0f));
        Close.setShadowSize(0);
        Close.setSelectable(true);
        Close.show();
    }


    public void showInventory(Map<Integer, ItemModel> items)
    {
        this.setClose(true);

        inventoryPanel = new InventoryPanel(player);
        inventoryPanel.show(items);
    }
}
