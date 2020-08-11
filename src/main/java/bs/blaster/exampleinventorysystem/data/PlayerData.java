package bs.blaster.exampleinventorysystem.data;

import bs.blaster.exampleinventorysystem.ItemModel;
import bs.blaster.exampleinventorysystem.PlayerPanel;
import bs.blaster.exampleinventorysystem.constant.PanelType;
import net.gtaun.shoebill.common.player.PlayerLifecycleObject;
import net.gtaun.shoebill.constant.TextDrawAlign;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.data.Vector2D;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.PlayerTextdraw;
import net.gtaun.util.event.EventManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerData extends PlayerLifecycleObject {
    private Player player;
    private Map<Integer, ItemModel> item;
    private ArrayList<PlayerTextdraw> itemInfo;
    private int selected;
    private PlayerTextdraw test;
    private PanelType panelSelected;
    private PlayerPanel playerPanel;

    public PlayerData(EventManager eventManager, Player player) {
        super(eventManager, player);
        this.player = player;
        this.itemInfo = new ArrayList<PlayerTextdraw>();
        this.playerPanel = new PlayerPanel(player);
        this.item = new HashMap<>(12);
        this.panelSelected = PanelType.Inventory;
        System.out.println("Test");
    }

    public PlayerPanel getPlayerPanel()
    {
        return this.playerPanel;
    }
    public Player getPlayer() {
        return player;
    }

    int getSelected()
    {
        return selected;
    }

    void setSelected(int index)
    {
        this.selected = index;
    }

    public PanelType getPanelSelected() { return this.panelSelected; }
    public void setPanelSelected(PanelType panelType)
    {
        this.panelSelected = panelType;
    }

    void setItemProvider()
    {

    }

    public Map<Integer, ItemModel> getItems()
    {
        return this.item;
    }

    private void createInfoItem(int slot, float tx, float ty, float sizex, float sizey, int type)
    {
            PlayerTextdraw infotextdraw = PlayerTextdraw.create(player, tx + 40.0f, ty + 40.0f, "");
            infotextdraw.setAlignment(TextDrawAlign.RIGHT);
            infotextdraw.setColor(new Color(0xECECECFF));
            infotextdraw.setBackgroundColor(Color.WHITE);
            infotextdraw.setLetterSize(new Vector2D(0.20f, 1.0f));
            infotextdraw.setTextSize(new Vector2D(sizex, sizey));
            infotextdraw.setBackgroundColor(new Color(0x00000088));
            infotextdraw.setOutlineSize(1);
            infotextdraw.show();

            itemInfo.add(infotextdraw);
    }

    private void destroyInfoItem()
    {

    }

    @Override
    protected void onInit() {

    }

    @Override
    protected void onDestroy() {

    }
}
