__config() -> {
  'requires' -> {
    'carpet' -> '>=1.4.33',
    'minecraft' -> '>=1.17'
  },
  'command_permission' -> 'ops',
  'libraries' -> [
    {
      'source' -> 'https://raw.githubusercontent.com/BisUmTo/scarpet/master/swapitem.sc',
      'target' -> 'swapitem.scl'
    }
  ]
}
