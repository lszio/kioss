//
//  Provides optimized type hints for clojurescript screeps javascript interop.
//
/**
 * @const
 */
var process = {
  argv: {},
  argc: {}
};

/**
 * @type {Object}
 */
var module = {
  exports: {}
};

// Actual Screeps API

/**
 * @type {Object}
 */
var Memory = {};

/**
 * @const
 */
var Game = {
  creeps: {},
  spawns: {},
  rooms: {}
};

var Store = function () {
  this.energy = {};
};
Store.prototype.getCapacity = function (resource) {};
Store.prototype.getFreeCapacity = function (resource) {};
Store.prototype.getUsedCapacity = function (resource) {};

var RoomPosition = function () {
  this.roomName = {};
  this.x = {};
  this.y = {};
};
RoomPosition.prototype.findClosestByRange = function (type, opts) {};
RoomPosition.prototype.findPathTo = function (type, opts) {};

var Creep = function () {
  /**
   * @type {Array<Object>}
   */
  this.body = [
    {
      boost: {},
      type: {},
      hits: {}
    }
  ];

  /**
   * @type {Store}
   */
  this.store = function () {};

  this.carryCapacity = {};

  /**
   * @type {RoomPosition}
   */
  this.pos = function () {};

  /**
   * @type {Room}
   */
  this.room = function () {};
};
Creep.prototype.attack = function (target) {};
Creep.prototype.attackController = function (target) {};
Creep.prototype.build = function (target) {};
Creep.prototype.cancelOrder = function (methodName) {};
Creep.prototype.claimController = function (target) {};
Creep.prototype.dismantle = function (target) {};
Creep.prototype.drop = function (resourceType, amount) {};
Creep.prototype.generateSafeMode = function (controller) {};
Creep.prototype.getActiveBodyparts = function (type) {};
Creep.prototype.harvest = function (target) {};
Creep.prototype.heal = function (target) {};
Creep.prototype.move = function (direction) {};
Creep.prototype.moveByPath = function (path) {};
Creep.prototype.moveTo = function (target) {};
Creep.prototype.notifyWhenAttacked = function (enabled) {};
Creep.prototype.pickup = function (target) {};
Creep.prototype.rangedAttack = function (target) {};
Creep.prototype.rangedHeal = function (target) {};
Creep.prototype.rangedMassAttack = function () {};
Creep.prototype.repair = function (target) {};
Creep.prototype.reserveController = function (target) {};
Creep.prototype.say = function (message, isPublic) {};
Creep.prototype.signController = function (target, text) {};
Creep.prototype.suicide = function () {};
Creep.prototype.transfer = function (target, resourceType, amount) {};
Creep.prototype.upgradeController = function (target) {};
Creep.prototype.withdraw = function (target, resourceType, amount) {};

var Room = function () {
  /**
   * @type {StructureController}
   */
  this.controller = function () {};

  this.energyAvailable = {};

  this.energyCapacityAvailable = {};

  this.memory = {};

  /**
   * @type {StructureStorage}
   */
  this.storage = function () {};

  /**
   * @type {StructureTerminal}
   */
  this.terminal = function () {};
};
Room.prototype.find = function (type, options) {};
