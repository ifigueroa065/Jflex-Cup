#  :computer: Jflex-Cup :green_heart:
Herramientas que puedes utilizar para análisis Léxico y Sintáctico

- Apache NetBeans IDE 16
- Java: 19.0.2

##  :mag: JFlex

##   :arrow_lower_right: Lo que debes descargar 
      https://www.jflex.de/
      
## Generador - Análisis Léxico :alien::purple_heart:

### 
  ```  
      ☑️ se coloca la ruta donde tenemos instalado el JDK

      SET JAVA_HOME="C:\Program Files\Java\jdk-19\bin"
      SET PATH=%JAVA_HOME%;%PATH%
      SET CLASSPATH=%JAVA_HOME%;

      ☑️ Colocamos la ruta donde están los archivos a compilar
      cd C:\Users\isail\OneDrive\Documents\Jflex-Cup\Ejemplo\src\Analizadores

      ☑️ Se utiliza la ruta del jflex.rar y el nombre del archivo a crear
      java -jar C:\Users\isail\OneDrive\Documents\Jflex-Cup\Ejemplo\Fuentes\jflex-1.9.0\lib\jflex-full-1.8.2.jar A_Lexico.jflex
      pause 
  ```      

##  :tea: CUP

##   :arrow_lower_right: Lo que debes descargar 
      http://www2.cs.tum.edu/projects/cup/

## Generador - Análisis Sintáctico :alien::yellow_heart:

### 

 ```  
      ☑️ se coloca la ruta donde tenemos instalado el JDK

      SET JAVA_HOME="C:\Program Files\Java\jdk-19\bin"
      SET PATH=%JAVA_HOME%;%PATH%
      SET CLASSPATH=%JAVA_HOME%;

      ☑️ Colocamos la ruta donde están los archivos a compilar
      cd C:\Users\isail\OneDrive\Documents\Jflex-Cup\Ejemplo\src\Analizadores

      ☑️ Se utiliza la ruta del jflex.rar y el nombre del archivo a crear
      cd C:\Users\isail\OneDrive\Documents\Jflex-Cup\Ejemplo\src\Analizadores
      java -jar C:\Users\isail\OneDrive\Documents\Jflex-Cup\Ejemplo\Fuentes\java-cup-11b.jar -parser analisis_sintactico -symbols Simbolos A_Sintactico.cup
      pause
  ```
