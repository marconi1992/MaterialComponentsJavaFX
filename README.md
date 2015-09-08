# MaterialComponentsJavaFX
Its a Framework that allow add Material Components in JavaFX applications
## Get Started
1. Add the controls.css Stylesheet in the Scene object
```
scene.getStylesheets().add(getClass().getResource("widgets/styles/controls.css").toExternalForm());
```

2. Import the class file that will use in the fxml file.<strong>Note:</strong>Check if the package name is correct,this depends on the hierarchy of your project and the location of widgets package 
```
<?import materialcomponents.widgets.EditText?>
```

##Text Field
###Single Line
<img src="https://lh3.googleusercontent.com/RgReLBqYLE1o1nbo5DIBddPileVbKznZVqpjNUR3T77eb7VR_0s0n2HqUv1RDfcyCvn-y0XnWT2wrLScM7qcE2s9tCf4_MAftBzbWyWCsaMEZSvLUQphO9zz91FCOFUAJU6xS4tcehw-e29g08SRfxvheAudXN6vqawxe2X9JhK_oBiATkPAt9N7Xg_cBOmakat_ePlcWOXgZsFrJVPNzvmOrHY1VGHUa_TO2QavB9UHWXxIrYTXrgHudTpr3w6FzoA75k8svpL4eysdikhonxw2DbYrDgztaHBHUYJFPJhJavshCW67OEY2dozuGdd3osdMzKKy5CaW1Tb6SG61FYgchrA-MXstUKYCEBA1pBbouhdpordXlyTA34u3sG46Npsi74-0NFjVlDrofqB2ruQn_OuGPYTsSPT7RI8VqVUZKE0mmZvWi6J12HA0yaFHCt46twS0mGFdEby4eEDal-H1kIPgpFW63uXnsKLQvfqLnuHkiGU50PF1pwCrUPJXb5HVUAJgmfD-2LqHkfvRxg=w600-h281-no"/>
<p>To create a simple text field is necessary add a "prompText" attribute with the content</p>
```
<EditText prompText="Nombre de Usuario"  />
```
###Floating Label
<img src="https://lh3.googleusercontent.com/VSfhtTF1ORvWkQoiI3j9XlxqtoOZZ2Ls37xdeAp-eMCR7AFimTn2gu87YkYjmkfQyPXdr_ywFf5iAbvG_k3kiCGZn8lekdK7AfV1cZrYUf2xwLKn8BODtHKfSfSnu9ZjKWfUZZ0VR8nTNkf02ILIFu82GfZoxAeabyG--8Pt8H9iaPUyXBfJRcR0sz09RJloWs9zmlJtOF8e_WsJXe5c2c_bAjfniNvXID4AisIqpVgb8vf_NHFv7SnisA8CMsXJ-anRiAKKc2fOSJRWwVw-YA7tQSKUbONudXzO9EdOd0404Zx9GqRYtsOKYV2V95oWRU8anW56G8-W4Km1tK6Ik-UfS-IsOEWCff88bqMB9fl405IQ_9AmA26DGfZ6Xnec63w5Hw9UOkLayx6_GEN82t7WSy4YTE0yJxEwRezUQI4U2qFyiXLDW_Rj9av9yKFvDTh7sq8l4_4aWZnbgwkYdSMsB80rL-MwTDywQF_oM8e0l4tq_KrZ2vRYRzXlQyfFaOEVjw07jOQ-pDZjkteD4Q=w583-h230-no"/>
To create a simple text field is necessary add a "hint" attribute with the content.
```
<EditText hint="Nombre de Usuario" />
```
###Text Area and Password Field
<img src="https://lh3.googleusercontent.com/NP5ebivSx40VkSmXFPk_nsX9HZlDhjd91kqtwCSlU_-EHboQit0Qt_ZusOkPES8bFv46RdXJIl2Uda2C1KVEwF-XC7ueRG8BMOnsDbOBHjJAUzcw8As1gZMUMQnjXtwcnScjIiIHlq7yyhzKi5iEHlP4m2epTYATxDXfNhOP9AolCnA4nJaGUtkHlTnIHJ2U5CunDgXzTqjTtdrhXj_JhIVFiVia9ajbQ3WoW_4cQgKDPvak4Wc5hL_wvd7W1v-Ont0Eebxb_wlU5YQN9uh7qKmxOzOoJXwIrsAT_cLydBN9EX5OL0U_jAU8qtkpRP66jillADMYOZ5VO1_C9Y-m7UokOt3zSsgXulD1L2xhK4EOHhu0zeITSEUki0WjACK4giV7YViiYqHgDYWDqH0Q_e5oCKv6NoqJfDn6M2kJ9i_yzi9X1wr1LdDw0FPE9txfr1yxU5wJgTxgj7iiG7ydKiLwhwZbP0YbhLTPMkWT0Y1MH89Rz6PogEoWJaYTJ50amlNYxQoLQobQBxcqkDM7vA=w491-h283-no"/>
Both support a simple and floating label , to create a text area its  textArea attribute must be set true , in the same way to create a Password Field the passwordField attribute must be set true
```
<EditText passwordField="true" prompText="Contraseña"/>
<EditText passwordField="true" hint="Contraseña"/>
<EditText textArea="true" prompText="Descripción"/>
<EditText textArea="true" hint="Descripción"/>
```
###Icon
<img src="https://lh3.googleusercontent.com/pZmhxgXmElVhtSJXW4lmS9sFhbV9HdME1v_uSw5vRpVgD4MGZaKNDORwfEjyNQJomNf_Nn3xeuWPbpkiAKUR9oBMoG6vr3eceVKJODOOIyQlc1yTOb7r8ja3m7Apq6kBGIAVZ-AO4C7lv9R7GJw1NQzBia34EFf31wh56-jmmhrNox8nn_Oj6QWuTejom8iZUMdI0Vl1DOyDfTM2Jf7_2db1fA9DTJ-99Dd_ETTjPlHVQAJXo5bDkx2HrKcMt7o9mH4C3gJUuasmrm2-opZ4D3Ztl3rHzBgc1X18sy4TryirvSuHv4dedPzbLtaujmQy33RH90DY9vVJYoik1MxH2QyWk13ZW0vlgFm0Vrfq9iIoUORqInyY8P1ig1N1BSF8BAejqhe9Q634cepX7qqNGnGTScKS0YgGAS3A-2ZDgBUQmqI95R9clXLaY_Gpa2i70vBycJVTtSnWIZpy3tp_g91DMCpE6pPPYzshVeu9UFeyxh1AJCVBxIdk1XzyokzzzgsOz5QznpNsv1gAWRcj8w=w582-h300-no"/>
To create a Icon in the text field  in the "icon" attribute must be  set the path from the svg file
```
<EditText hint="Nombre de Usuario" icon="@img/image.svg" />
```


