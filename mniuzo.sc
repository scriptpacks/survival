global_scripts = [
    'swapitem',
    'silkyblockstates',
    'specialnametags',
    'treecapitator',
    'placeableplants',
    'villagerleash',
    'prunedplants',
    'villagerleash',
    'pillagerleash',
    'betteritemframes',
    'skull',
];

global_scriptpack = map(global_scripts, {'source' -> 'https://raw.githubusercontent.com/BisUmTo/scarpet/master/'+_+'.sc'});

__config() -> {
    'requires' -> {
        'carpet' -> '>=1.4.33',
        'minecraft' -> '>=1.17'
    },
    'command_permission' -> 'ops',
    'libraries' -> global_scriptpack,
    'commands' -> {
        'uninstall' -> 'uninstall'
    }
};

uninstall() -> (
    for(global_scripts,
        run('script remove '+_);
    );
    'script remove '+system_info('app_name');
    'script unload '+system_info('app_name');
);

__on_close() -> (
    for(global_scripts,
        run('script unload '+_);
    );
)
