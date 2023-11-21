# No Armors

## How to use ?

This is a Fabric Mod, you need The [Fabric Mod Loader](https://fabricmc.net). Place the mod in your `mods` folder.

## How does this work ?
This mod uses [Mixin](https://github.com/SpongePowered/Mixin) to hook the `render` method inside the `ArmorFeatureRenderer` class. Then adds a condition before rendering the armors.