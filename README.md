# MaterialComponentsJavaFX
Its a Framework that allow add Material Components in JavaFX applications
## Get Started
1. Add the controls.css Stylesheet in the Scene object
```javascript
scene.getStylesheets().add(getClass().getResource("widgets/styles/controls.css").toExternalForm());
```

2. Import the class file that will use in the fxml file.<strong>Note:</strong>Check if the package name is correct,this depends on the hierarchy of your project and the location of widgets package 
```javascript
<?import materialcomponents.widgets.EditText?>
```

##Text Field
###Single Line
![alt text](http://marconideveloper.16mb.com/img/materialcomponents/single%20line%20edit%20text.png "Single Line")

To create a simple text field is necessary add a "prompText" attribute with the content
```html
<EditText prompText="Nombre de Usuario"  />
```
###Floating Label
![Float Label](http://marconideveloper.16mb.com/img/materialcomponents/folat%20text%20field.png "Float Label")

To create a simple text field is necessary add a "hint" attribute with the content.
```html
<EditText hint="Nombre de Usuario" />
```
###Text Area and Password Field
![alt text](http://marconideveloper.16mb.com/img/materialcomponents/text%20area%20and%20passwordField.png "TextArea and PasswordField")

Both support a simple and floating label , to create a text area its  textArea attribute must be set true , in the same way to create a Password Field the passwordField attribute must be set true
```html
<EditText passwordField="true" prompText="Contraseña"/>
<EditText passwordField="true" hint="Contraseña"/>
<EditText textArea="true" prompText="Descripción"/>
<EditText textArea="true" hint="Descripción"/>
```
###Icon
![alt text](http://marconideveloper.16mb.com/img/materialcomponents/icon%20text%20field.png "Icon")

To create a Icon in the text field  in the "icon" attribute must be  set the path from the svg file
```html
<EditText hint="Nombre de Usuario" icon="@img/image.svg" />
```



