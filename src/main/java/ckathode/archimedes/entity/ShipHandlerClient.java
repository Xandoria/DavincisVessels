package ckathode.archimedes.entity;

import ckathode.archimedes.ArchimedesShipMod;
import ckathode.archimedes.network.MsgFarInteract;
import net.minecraft.entity.player.EntityPlayer;

public class ShipHandlerClient extends ShipHandlerCommon {
    public ShipHandlerClient(EntityShip entityship) {
        super(entityship);
    }

    @Override
    public boolean interact(EntityPlayer player) {
        if (player.getDistanceSqToEntity(ship) >= 36D) {
            MsgFarInteract msg = new MsgFarInteract(ship);
            ArchimedesShipMod.instance.pipeline.sendToServer(msg);
        }

        return super.interact(player);
    }

    @Override
    public void onChunkUpdate() {
        super.onChunkUpdate();
    }
}
