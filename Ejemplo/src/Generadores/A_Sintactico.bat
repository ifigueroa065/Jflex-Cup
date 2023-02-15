SET JAVA_HOME="C:\Program Files\Java\jdk-19\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd C:\Users\isail\OneDrive\Documents\Jflex-Cup\Ejemplo\src\Analizadores
java -jar C:\Users\isail\OneDrive\Documents\Jflex-Cup\Ejemplo\Fuentes\java-cup-11b.jar -parser analisis_sintactico -symbols Simbolos A_Sintactico.cup
pause
