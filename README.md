# Cataclysm-Potfix-Addon-1.19.2
Patches a bug in L_Enders_Cataclysm-2.46-1.19.2, that causes the game to crash when breaking/interacting with a Decorated Pot.

## Usage/Installation
- Download [L_Enders_Cataclysm-2.46-1.19.2](https://www.curseforge.com/minecraft/mc-mods/lendercataclysm/files/6470672).
- Download [potfix-cataclysm-addon-1.0.6.jar](https://github.com/inklightly/Cataclysm-Potfix-Addon-1.19.2/releases/tag/1.19.2).
- Drop both into your `mods/` folder.


## Important
Cataclysm is a minecraft mod created by L_Ender. \
I am not L_Ender, nor am I affiliated with L_Ender. The original mod can be found here: \
https://www.curseforge.com/minecraft/mc-mods/lendercataclysm \
 \
[L_Enders_Cataclysm-2.46-1.19.2](https://www.curseforge.com/minecraft/mc-mods/lendercataclysm/files/6470672) is a required dependency. \
Please make sure you have the original mod installed before launching. \
 \
I will not be pushing updates, this is a bandaid as 1.19.2 isn't supported by the original developer anymore. \
 \
Created with assistance from ChatGPT. I can code, but I don't speak Java.

## Tech notes
This is a direct fix for the following crash:
```
java.lang.AbstractMethodError: Receiver class com.min01.archaeology.blockentity.DecoratedPotBlockEntity does not define or inherit an implementation of the resolved method 'abstract net.minecraft.core.BlockPos getBlockPos()' of interface com.min01.archaeology.container.RandomizableContainer.
at com.min01.archaeology.container.RandomizableContainer.unpackLootTable(RandomizableContainer.java:95) ~[L_Enders_Cataclysm-2.46-1.19.2.jar%23159!/:2.46-1.19.2] {re:mixin,re:classloading,pl:mixin:APP:mixample.mixins.json:RandomizableContainerMixin,pl:mixin:A}
at com.min01.archaeology.blockentity.DecoratedPotBlockEntity.getTheItem(DecoratedPotBlockEntity.java:145) ~[L_Enders_Cataclysm-2.46-1.19.2.jar%23159!/:2.46-1.19.2] {re:classloading}
at com.min01.archaeology.container.ContainerSingleItem.m_8020_(ContainerSingleItem.java:53) ~[L_Enders_Cataclysm-2.46-1.19.2.jar%23159!/:2.46-1.19.2] {re:classloading}
at net.minecraft.world.Containers.m_18986_(Containers.java:23) ~[client-1.19.2-20220805.130853-srg.jar%23162!/:?] {re:classloading}
at net.minecraft.world.Containers.m_19002_(Containers.java:14) ~[client-1.19.2-20220805.130853-srg.jar%23162!/:?] {re:classloading}
at com.min01.archaeology.block.DecoratedPotBlock.m_6810_(DecoratedPotBlock.java:227) ~[L_Enders_Cataclysm-2.46-1.19.2.jar%23159!/:2.46-1.19.2] {re:classloading}
...
```
This mod adds a default `getLevel()` / `getBlockPos()` implementation for `RandomizableContainer`, and a mixin for `DecoratedPotBlockEntity` so loot tables can unpack safely. \
 \
If you intend to rework this code, [L_Enders_Cataclysm-2.46-1.19.2](https://www.curseforge.com/minecraft/mc-mods/lendercataclysm/files/6470672) needs to be placed in the libs folder.
