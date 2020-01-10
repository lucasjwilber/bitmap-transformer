# bitmap-transformer

This app is used to transform a bitmap image from the CLI. 
To use it, run 
**./gradlew run --args 'input output transform'**
where input is the .bmp file, output is the destination file name(without the .bmp extension), and transform is the method used to transform the bitmap image.

## Current methods:

  #### changeColor(**old color**, **new color**)
    -old color and new color should be strings, eg red, blue
  