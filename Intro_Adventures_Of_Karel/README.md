# What Is Karel the Robot?

## Everything you need to know about Karel on one page

## Methods:
- move();
- frontIsClear()
- leftIsClear()
- rightIsClear()
- facingNorth()
- facingSouth()
- facingEast()
- facingWest()
- beepersPresent()
- beepersInBag()

## Sensory conditions:
- frontIsBlocked()
- leftIsBlocked()
- rightIsBlocked()
- notFacingNorth()
- notFacingSouth()
- notFacingEast()
- notFacingWest()
- noBeepersPresent()
- noBeepersInBag()


## Java control structures:
```
if (some sensory condition) {
    …any Karel code…
} else {
    …any Karel code…
}
```

```
while (some sensory condition) {
    …any Karel code…
}
```

```
for (int i=0; i<number; i++) {
    …any Karel code…
}
```

## A simple Karel program:
```
import stanford.karel.*;
public class SimpleKarelProgram extends Karel {
    public void run() {
        pickBeeper();
        turnLeft();
        move();
        turnRight();
        while (frontIsClear()) {
            putBeeper();
            move();
        }
    }
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}
```