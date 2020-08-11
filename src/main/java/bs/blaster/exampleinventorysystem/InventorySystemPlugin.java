package bs.blaster.exampleinventorysystem;

import bs.blaster.exampleinventorysystem.constant.Item;
import bs.blaster.exampleinventorysystem.data.PlayerData;
import bs.blaster.exampleinventorysystem.data.PlayerManager;
import net.gtaun.shoebill.common.player.PlayerLifecycleHolder;
import net.gtaun.shoebill.constant.TextDrawAlign;
import net.gtaun.shoebill.constant.TextDrawFont;
import net.gtaun.shoebill.data.*;
import net.gtaun.shoebill.object.Textdraw;
import net.gtaun.shoebill.resource.Plugin;
import net.gtaun.util.event.EventManager;
import net.gtaun.util.event.EventManagerNode;
import net.gtaun.shoebill.object.Player;

public class InventorySystemPlugin extends Plugin {
    private static InventorySystemPlugin instance;

    public static InventorySystemPlugin getInstance() {
        if(instance == null)
            instance = new InventorySystemPlugin();
        return instance;
    }

    private EventManager eventManager;
    private EventManagerNode eventManagerNode;
    private PlayerLifecycleHolder playerLifecycleHolder;
    private PlayerManager playerManager;

    private static Textdraw InventoryBox;

    private static Textdraw InventoryBoxChangeClose;
    private static Textdraw InventoryBoxChange;

    public Textdraw[] InventoryPreviewItem = new Textdraw[17];
    public Textdraw[] InventoryPreviewBox = new Textdraw[17];

    @Override
    protected void onEnable() throws Throwable {
        instance = this;

        eventManager = getEventManager();
        eventManagerNode = eventManager.createChildNode();
        playerLifecycleHolder = new PlayerLifecycleHolder(eventManager);
        playerLifecycleHolder.registerClass(PlayerData.class);

        playerManager = new PlayerManager();

        InventoryBoxChangeClose = Textdraw.create(new Vector2D(474.0f, 120.0f), "X");
        InventoryBoxChangeClose.setFont(TextDrawFont.FONT2);
        InventoryBoxChangeClose.setLetterSize(new Vector2D(0.29f, 1.20f));
        InventoryBoxChangeClose.setColor(Color.WHITE);
        InventoryBoxChangeClose.setAlignment(TextDrawAlign.CENTER);
        InventoryBoxChangeClose.setTextSize(new Vector2D(10.0f, 11.0f));
        InventoryBoxChangeClose.setShadowSize(0);
        InventoryBoxChangeClose.setSelectable(true);

        InventoryBoxChange = Textdraw.create(new Vector2D(114.000000f, 120.0f), "_");
        InventoryBoxChange.setBackgroundColor(Color.WHITE);
        InventoryBoxChange.setFont(TextDrawFont.FONT2);
        InventoryBoxChange.setLetterSize(new Vector2D(0.019997f, 22.700021f));
        InventoryBoxChange.setColor(Color.WHITE);
        InventoryBoxChange.setOutlineSize(0);
        InventoryBoxChange.setUseBox(true);
        InventoryBoxChange.setBoxColor(new Color(0x00000088));
        InventoryBoxChange.setTextSize(new Vector2D(480.0f, 87.000000f));

        InventoryBox = Textdraw.create(new Vector2D(144.000000f, 120.0f), "_");
        InventoryBox.setBackgroundColor(Color.WHITE);
        InventoryBox.setLetterSize(new Vector2D(0.019998f, 25.00f));
        InventoryBox.setColor(new Color(154));
        InventoryBox.setShadowSize(1);
        InventoryBox.setUseBox(true);
        InventoryBox.setBoxColor(new Color(0x00000088));
        InventoryBox.setTextSize(new Vector2D(459.0f, 200.0f));
        InventoryBox.setPreviewModel(5);
        InventoryBox.setPreviewModelRotation(16.000000f, 0.000000f, -55.000000f, 1.000000f);
        InventoryBox.setSelectable(false);

        float posy = 164.0f;
        float sizex = 40.0f;
        for (int i = 0; i < 2; i++)
        {
            CreateInventoryTextdrawGlobal(i, 0, new Vector2D(151.0f + (0 * (sizex + 1.0f)), posy), sizex, 43.0f, false);
            CreateInventoryTextdrawGlobal(i, 1, new Vector2D(151.0f + (1 * (sizex + 1.0f)), posy), sizex, 43.0f, false);
            CreateInventoryTextdrawGlobal(i, 2, new Vector2D(151.0f + (2 * (sizex + 1.0f)), posy), sizex, 43.0f, false);
            CreateInventoryTextdrawGlobal(i, 3, new Vector2D(151.0f + (0 * (sizex + 1.0f)), posy + 44.0f), sizex, 43.0f, false);
            CreateInventoryTextdrawGlobal(i, 4, new Vector2D(151.0f + (1 * (sizex + 1.0f)), posy + 44.0f), sizex, 43.0f, false);
            CreateInventoryTextdrawGlobal(i, 5, new Vector2D(151.0f + (2 * (sizex + 1.0f)), posy + 44.0f), sizex, 43.0f, false);
            CreateInventoryTextdrawGlobal(i, 6, new Vector2D(151.0f + (0 * (sizex + 1.0f)), posy + 88.0f), sizex, 43.0f, false);
            CreateInventoryTextdrawGlobal(i, 7, new Vector2D(151.0f + (1 * (sizex + 1.0f)), posy + 88.0f), sizex, 43.0f, false);
            CreateInventoryTextdrawGlobal(i, 8, new Vector2D(151.0f + (2 * (sizex + 1.0f)), posy + 88.0f), sizex, 43.0f, false);
            CreateInventoryTextdrawGlobal(i, 9, new Vector2D(151.0f + (0 * (sizex + 1.0f)), posy + 132.0f), sizex, 43.0f, false);
            CreateInventoryTextdrawGlobal(i, 10, new Vector2D(151.0f + (1 * (sizex + 1.0f)), posy + 132.0f), sizex, 43.0f, false);
            CreateInventoryTextdrawGlobal(i, 11, new Vector2D(151.0f + (2 * (sizex + 1.0f)), posy + 132.0f), sizex, 43.0f, false);

            CreateInventoryTextdrawGlobal(i, 12, new Vector2D(295.0f + (0 * 28.0f), 310.0f), 27.0f, 31.0f, true);
            CreateInventoryTextdrawGlobal(i, 13, new Vector2D(295.0f + (1 * 28.0f), 310.0f), 27.0f, 31.0f, true);
            CreateInventoryTextdrawGlobal(i, 14, new Vector2D(295.0f + (2 * 28.0f), 310.0f), 27.0f, 31.0f, true);
            CreateInventoryTextdrawGlobal(i, 15, new Vector2D(295.0f + (3 * 28.0f), 310.0f), 27.0f, 31.0f, true);
            CreateInventoryTextdrawGlobal(i, 16, new Vector2D(295.0f + (4 * 28.0f), 310.0f), 27.0f, 31.0f, true);
        }
    }

    @Override
    protected void onDisable() throws Throwable {
        playerLifecycleHolder.destroy();
    }

    private void CreateInventoryTextdrawGlobal(int type, int i, Vector2D position, float sizex, float sizey, boolean bardisable)
    {
        if (type == 1)
        {
            InventoryPreviewItem[i] = Textdraw.create(position, "");
            InventoryPreviewItem[i].setFont(TextDrawFont.MODEL_PREVIEW);
            InventoryPreviewItem[i].setPreviewModel(19382);
            InventoryPreviewItem[i].setColor(new Color(-1));
            InventoryPreviewItem[i].setBackgroundColor(new Color(0xFFFFFF00));
            InventoryPreviewItem[i].setLetterSize(new Vector2D(0.500000f, 1.000000f));
            InventoryPreviewItem[i].setTextSize(new Vector2D(sizex, sizey));
        }
        else
        {
            InventoryPreviewBox[i] = Textdraw.create(position, "LD_SPAC:WHITE");
            InventoryPreviewBox[i].setFont(TextDrawFont.SPRITE_DRAW);
            InventoryPreviewBox[i].setColor(new Color(0xECECECFF));
            InventoryPreviewBox[i].setBackgroundColor(new Color(255));
            InventoryPreviewBox[i].setLetterSize(new Vector2D(0.500000f, 1.000000f));
            InventoryPreviewBox[i].setTextSize(new Vector2D(sizex, sizey));
            InventoryPreviewBox[i].setSelectable(true);
        }
    }

    public Textdraw getInventoryBoxChange() { return InventoryBoxChange; }
    public Textdraw InventoryBox() { return InventoryBox; }
    public Textdraw InventoryBoxChangeClose() { return InventoryBoxChangeClose; }

    public void destroyInventory(Player player)
    {
        for(int i = 0; i< (Item.MaxEquipedItems+Item.MaxInventoryItem);i++)
        {
            InventoryPreviewBox[i].hide(player);
        }
        InventoryBox.hide(player);

        player.selectTextDraw(new Color(1));
    }

    public EventManager getEventManagerInstance() {
        return eventManagerNode;
    }

    public PlayerLifecycleHolder getPlayerLifecycleHolder() {
        return playerLifecycleHolder;
    }
}
