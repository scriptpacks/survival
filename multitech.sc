global_scripts = [
    'betteritemframes',
    'endermannogrief',
    'fastredstonerecipes',
    'horsestats',
    'lookme',
    'placeableplants',
    'playerheadrecipe',
    'prunedplants',
    'ropes',
    'skull',
    'sitanywhere',
    'recolorableblocks',
    'timebar'
];

global_scriptpack = map(global_scripts, {'source' -> 'https://raw.githubusercontent.com/BisUmTo/scarpet/master/'+_+'.sc'});

__config() -> {
    'requires' -> {
        'carpet' -> '>=1.4.66',
        'minecraft' -> '>=1.18.2',
        'carpet-extra' -> '>=1.4.64',
        'carpet-tis-addition' -> '>=1.30.0',
        'essentialaddons' -> '>=1.18.2-1.2.1',
        'pca' -> '>=0.2.5-beta+8e41bb1',
        'rug' -> '>=1.18.2-1.2.1'
    },
    'command_permission' -> 'ops',
    'libraries' -> global_scriptpack,
    'commands' -> {
        'uninstall' -> 'uninstall',
        'install' -> ['install',false],
        'install survival' -> ['install',false],
        'install creative' -> ['install',true]
    },
    'scope' -> 'global'
};

global_app_name = system_info('app_name');
print(format('l Script Pack "'+global_app_name+'" loaded'));

uninstall() -> (
    for(global_scripts,
        run('script remove '+_);
    );
    run('script remove '+global_app_name);
    run('script unload '+global_app_name);
    print(format('r Script Pack "'+global_app_name+'" uninstalled'))
);

install(creative) -> for([
    
    _(c)->'/gamerule playersSleepingPercentage 0',
    
    // STAT COMMAND
    _(c)->'/carpet scriptsAppStore CommandLeo/scarpet/contents/programs',
    _(c)->'/script download stat.sc',

    // CARPET
    _(c)->'/carpet setDefault antiCheatDisabled true',
    _(c)->'/carpet setDefault defaultLoggers mobcaps,tps',
    _(c)->'/carpet setDefault flippinCactus true',
    _(c)->'/carpet setDefault lagFreeSpawning true',
    _(c)->'/carpet setDefault missingTools true',
    _(c)->'/carpet setDefault renewableSponges true',
    _(c)->'/carpet setDefault stackableShulkerBoxes 64',
    _(c)->'/carpet setDefault xpNoCooldown true',
    _(c)->'/carpet setDefault updateSuppressionCrashFix true',
    _(c)->'/carpet setDefault commandScript ops',
    _(c)->if(c,'/carpet setDefault liquidDamageDisabled true'),
    _(c)->'/carpet setDefault commandPlayer true',
    _(c)->'/carpet setDefault ctrlQCraftingFix true',
    
    // CARPET EXTRA
    _(c)->'/carpet setDefault accurateBlockPlacement true',
    _(c)->'/carpet setDefault blockStateSyncing true',
    
    // CARPET FIXES
    _(c)->'/carpet-fixes setDefault sleepingResetsThunderFix true',
    _(c)->'/carpet-fixes setDefault delayBetweenAutoSaves 1200',
    _(c)->'/carpet-fixes setDefault beeNotLeavingHiveFix true',
    _(c)->'/carpet-fixes setDefault reIntroduceFallingBlockEntityPhase true',
    
    // CARPET TIS
    _(c)->'/carpet setDefault fakePlayerNamePrefix bot_',
    _(c)->if(!c,'/carpet setDefault opPlayerNoCheat true'),
    _(c)->if(c,'/carpet setDefault blockPlacementIgnoreEntity true'),
    _(c)->if(c,'/carpet setDefault commandLifeTime true'),
    _(c)->if(c,'/carpet setDefault creativeOpenContainerForcibly true'),
    _(c)->if(c,'/carpet setDefault enchantCommandNoRestriction true'),
    _(c)->if(c,'/carpet setDefault hopperCountersUnlimitedSpeed true'),
    
    // RUG
    _(c)->'/carpet setDefault campSleeping true',
    _(c)->'/carpet setDefault unpackableIce 9',
    _(c)->if(c,'/carpet setDefault reachDistance 10'),
    _(c)->'/carpet setDefault dragonDrops dragon_egg',
    
    // ESSENTIAL ADDONS
    _(c)->'/carpet setDefault commandCameraMode true',
    _(c)->'/carpet setDefault cameraModeSurvivalRestrictions true',
    _(c)->'/carpet setDefault editableSigns true',
    _(c)->'/carpet setDefault reloadFakePlayerActions true',
    _(c)->'/carpet setDefault reloadFakePlayers true',
    _(c)->'/carpet setDefault essentialCarefulBreak true',
    _(c)->'/carpet setDefault stackableShulkersInPlayerInventories true',
    
    // PLUSLS CARPET ADDITION
    _(c)->'/carpet setDefault pcaSyncProtocol true',
    _(c)->'/carpet setDefault pcaSyncPlayerEntity everyone'
],
    result=run(command = call(_, creative));
    if(!result:0 && command,
        logger('warn', 'Error running "'+command+'"')
    )
);

//__on_close() -> (
//    for(global_scripts,
//        run('script unload '+_);
//    );
//    print(format('r Script Pack "'+global_app_name+'" unloaded'))
//)
