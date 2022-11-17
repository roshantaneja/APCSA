## Arrays and ArrayLists: syntax

### How do I declare an array?

`int[] nums = new int[10];`

### How do I declare an ArrayList?

`ArrayList<String> name = new ArrayList<String>();`

### How do I access one value of an array?

`nums[3]; //prints out the 4th number in the array`

### How do I access one value of an ArrayList?

`names.get(7); //gets the 8th name in the arraylist`

### How do I change/set/assign one value in an array?

`nums[2] = 15; //sets the 3rd number to 15`

### How do I change/set/assign one value in an ArrayList?

`names.set(2, "tina"); //sets the 3rd name to "tina"`

### How do I loop through an array?

```
for (int i = 0; i < nums.length; i++) {
    println(nums[i]);
}
```

### How do I loop through an ArrayList?

```
for (int i = 0; i < names.size(); i++){
    print(names.get(i));
}
```

### How do I add one additional value to an array?

'// you cant! T_T'

* well in theory you could, just initialize a new array of `nums.length + 1` and add all of the old ones over and just add the new value at the end.

### How do I add one additional value to an ArrayList?

`names.add("neil");`

### How do I remove one value from an array?

`you cant! T_T`

### How do I remove one value from an ArrayList?

`names.remove(6); // removes the 7th element`
