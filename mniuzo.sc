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

print(format('l Script Pack "'+app_name+'" loaded'));

uninstall() -> (
    app_name = system_info('app_name');
    for(global_scripts,
        run('script remove '+_);
    );
    run('script remove '+app_name);
    run('script unload '+app_name);
    print(format('r Script Pack "'+app_name+'" uninstalled'))
);

__on_close() -> (
    app_name = system_info('app_name');
    for(global_scripts,
        run('script unload '+_);
    );
    print(format('r Script Pack "'+app_name+'" unloaded'))
)
