# bitmap-transformer

This app is used to transform a bitmap image from the CLI. 
To use it, run 
`./gradlew run --args 'input output transform'`
where **input** is the .bmp file, **output** is the destination file name(with the .bmp extension), and **transform** is the method used to transform the bitmap image.

## Current transforms:

  ### rotate
    -rotates the image counter-clockwise
    
  ### mirror
    -flips the image on the y axis

  ## white-[color]
    -replaces all whiteish colors with the specified color
    -supports red, orange, yellow, green, blue, purple, and black
  