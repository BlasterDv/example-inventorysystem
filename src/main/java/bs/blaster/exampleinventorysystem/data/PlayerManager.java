package bs.blaster.exampleinventorysystem.data;

import bs.blaster.exampleinventorysystem.InventorySystemPlugin;
import bs.blaster.exampleinventorysystem.constant.PanelType;
import net.gtaun.shoebill.constant.PlayerKey;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.event.player.*;
import net.gtaun.shoebill.object.*;
import net.gtaun.util.event.EventManager;
import org.apache.commons.lang3.time.StopWatch;

public class PlayerManager {

    public EventManager eventManager;

    public PlayerManager() {
        eventManager = InventorySystemPlugin.getInstance().getEventManagerInstance();

        eventManager.registerHandler(PlayerConnectEvent.class, (e) ->
        {
            //MsgboxDialog dialog = dialog.create(e.getPlayer(), "")
        });



        eventManager.registerHandler(PlayerClickPlayerTextDrawEvent.class, (e) -> {
            PlayerData playerData = InventorySystemPlugin.getInstance().getPlayerLifecycleHolder().getObject(e.getPlayer(), PlayerData.class);
            if (e.getPlayerTextdraw() == null) {
                InventorySystemPlugin.getInstance().destroyInventory(e.getPlayer());
            }
        });

        eventManager.registerHandler(PlayerKeyStateChangeEvent.class, (e) -> {
            if(e.getPlayer().getKeyState().isKeyPressed(PlayerKey.NO))
            {
                StopWatch watch = new StopWatch();
                watch.start();

                showPlayerPanel(e.getPlayer());

                watch.stop();
                System.out.println("Time Elapsed: " + watch.getNanoTime());

            }
        });
    }

    public  void showPlayerPanel(Player player)
    {
        PlayerData playerData = InventorySystemPlugin.getInstance().getPlayerLifecycleHolder().getObject(player,PlayerData.class);

        InventorySystemPlugin.getInstance().InventoryBox().show(player);

        if(playerData.getPanelSelected() == PanelType.Inventory)
        {
            playerData.getPlayerPanel().showInventory(playerData.getItems());
        }

        player.selectTextDraw(new Color(1));


    }

}
