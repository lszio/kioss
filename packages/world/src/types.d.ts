// example declaration file - remove these and add your own custom typings

// memory extension samples
declare interface CreepMemory {
  role: string;
  room: string;
  working: boolean;
  status: string;
}

declare interface IAliya {
  name: string;
  main: Function; // 主函数
  config: Function; // 配置接口
  sync: Function; // 同步游戏实际内容
}

// `global` extension samples
declare namespace NodeJS {
  interface Global {
    log: any;
  }
}
