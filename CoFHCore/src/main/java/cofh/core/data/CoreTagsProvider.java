package cofh.core.data;

import cofh.lib.util.references.FluidTagsCoFH;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static cofh.core.CoFHCore.FLUIDS;
import static cofh.lib.util.constants.Constants.ID_COFH_CORE;
import static cofh.lib.util.references.CoreIDs.*;

public class CoreTagsProvider {

    public static class Fluid extends FluidTagsProvider {

        public Fluid(DataGenerator gen, ExistingFileHelper existingFileHelper) {

            super(gen, ID_COFH_CORE, existingFileHelper);
        }

        @Override
        public String getName() {

            return "CoFH Core: Fluid Tags";
        }

        @Override
        protected void registerTags() {

            getOrCreateBuilder(FluidTagsCoFH.HONEY).add(FLUIDS.get(ID_FLUID_HONEY));
            getOrCreateBuilder(FluidTagsCoFH.POTION).add(FLUIDS.get(ID_FLUID_POTION));
            getOrCreateBuilder(FluidTagsCoFH.XP).add(FLUIDS.get(ID_FLUID_XP));
        }

    }

}
