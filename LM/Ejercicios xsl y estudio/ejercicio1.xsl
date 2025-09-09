<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:template match="/">
      <html>
         <body>
            <h1>Ejercicio 1 XSLT</h1>
            <h2>TABLA 1</h2>
            <h2>
               <xsl:value-of select="MiBibliotecaMP3/titulo" />
            </h2>
            <table style="border:1px solid blue;">
               <tr style="background-color:lightblue;">
                  <th style="text-align:left">Título</th>
                  <th style="text-align:left">Artista</th>
                  <th style="text-align:left">Disco</th>
               </tr>

               <!-- información del primer archivo -->
               <tr>
                  <td>
                     <xsl:value-of select="MiBibliotecaMP3/archivo[1]/cancion" />
                  </td>
                  <td>
                     <xsl:value-of select="MiBibliotecaMP3/archivo[1]/artista" />
                  </td>
                  <td>
                     <xsl:value-of select="MiBibliotecaMP3/archivo[1]/disco" />
                  </td>
               </tr>
               <!-- información del último archivo -->
               <tr>
                  <td>
                     <xsl:value-of select="MiBibliotecaMP3/archivo[last()]/cancion" />
                  </td>
                  <td>
                     <xsl:value-of select="MiBibliotecaMP3/archivo[last()]/artista" />
                  </td>
                  <td>
                     <xsl:value-of select="MiBibliotecaMP3/archivo[last()]/disco" />
                  </td>
               </tr>

            </table>

            <h2>TABLA 2: Tabla generada con for-each con todos los archivos y ordenada</h2>

            <table style="border:1px solid blue;">
               <tr style="background-color:lightblue;">
                  <th style="text-align:left">Canción</th>
                  <th style="text-align:left">Artista</th>
                  <th style="text-align:left">Disco</th>
                  <th style="text-align:left">Puntuación</th>
               </tr>

               <!-- un bucle -->
               <xsl:for-each select="//archivo">
               <xsl:sort select="puntuacion" data-type="number" order="descending"/>
                  <tr>
                     <td>
                        <xsl:value-of select="cancion" />
                     </td>
                     <td>
                        <xsl:value-of select="artista" />
                     </td>
                     <td>
                        <xsl:value-of select="disco" />
                     </td>
                     <td>
                        <xsl:value-of select="puntuacion" />
                     </td>
                  </tr>
               </xsl:for-each>

            </table>

            <h2>TABLA 3: Tabla generada con for-each con todos los archivos</h2>

            <table style="border:1px solid blue;">
               <tr style="background-color:lightblue;">
                  <th style="text-align:left">Canción</th>
                  <th style="text-align:left">Artista</th>
                  <th style="text-align:left">Disco</th>
                  <th style="text-align:left">Discografica</th>
               </tr>

               <!-- un bucle -->
               <xsl:for-each select="//archivo">
                  <tr>
                     <td>
                        <xsl:value-of select="cancion" />
                     </td>
                     <td>
                        <xsl:value-of select="artista" />
                     </td>
                     <td>
                        <xsl:value-of select="disco" />
                     </td>
                     <!-- nueva columna con la discográfica -->
                     <td>
                        <xsl:value-of select="disco/@discografica" />
                     </td>
                  </tr>
               </xsl:for-each>

            </table>

            <h2>TABLA 4: Tabla generada con for-each y predicados (anio >= 1997)</h2>

            <table style="border:1px solid blue;">
               <tr style="background-color:lightblue;">
                  <th style="text-align:left">Canción</th>
                  <th style="text-align:left">Artista</th>
                  <th style="text-align:left">Disco</th>
                  <th style="text-align:left">Discografica</th>
               </tr>

               <!-- un bucle -->
               <!--<xsl:for-each select="//archivo[disco/@anio >= '1987']">-->
               <xsl:for-each select="//archivo/disco[@anio >= '1987']">
                  <tr>
                     <td>
                        <!--<xsl:value-of select="cancion" />-->
                        <xsl:value-of select="../cancion" />
                     </td>
                     <td>
                        <xsl:value-of select="../artista" />
                     </td>
                     <td>
                        <xsl:value-of select="." />
                     </td>
                     <td>
                        <xsl:value-of select="@discografica" />
                     </td>
                  </tr>
               </xsl:for-each>

            </table>

            <h2>TABLA 5: Tabla generada con for-each con todos los archivos, ordenada y con IF</h2>

            <table style="border:1px solid blue;">
               <tr style="background-color:lightblue;">
                  <th style="text-align:left">Canción</th>
                  <th style="text-align:left">Artista</th>
                  <th style="text-align:left">Disco</th>
                  <th style="text-align:left">Puntuación</th>
                  <th style="text-align:left">Discográfica</th>
               </tr>

               <!-- un bucle -->
               <xsl:for-each select="//archivo">
                  <xsl:sort select="puntuacion" data-type="number" order="descending"/>
                  <tr>
                     <td>
                        <xsl:value-of select="cancion" />
                     </td>
                     <td>
                        <xsl:value-of select="artista" />
                     </td>
                     <td>
                        <xsl:value-of select="disco" />
                     </td>
                     <td>
                        <xsl:value-of select="puntuacion" />
                     </td>
                     <xsl:if test="disco/@discografica = 'capitol'">
                        <td>LA DISCOGRÁFICA CAPITOL VA A CERRAR!!! MEJOR CAMBIAR</td>
                     </xsl:if>
                     <xsl:if test="disco/@discografica != 'capitol'">
                        <td>
                           <xsl:value-of select="disco/@discografica" />
                        </td>
                     </xsl:if>
                  </tr>
               </xsl:for-each>

            </table>

            <h2>TABLA 6: Tabla generada con for-each con todos los archivos, ordenada y con CHOOSE</h2>

            <table style="border:1px solid blue;">
               <tr style="background-color:lightblue;">
                  <th style="text-align:left">Canción</th>
                  <th style="text-align:left">Artista</th>
                  <th style="text-align:left">Disco</th>
                  <th style="text-align:left">Puntuación</th>
                  <th style="text-align:left">Discográfica</th>
               </tr>

               <!-- un bucle -->
               <xsl:for-each select="//archivo">
                  <xsl:sort select="puntuacion" data-type="number" order="descending"/>
                  <tr>
                     <td>
                        <xsl:value-of select="cancion" />
                     </td>
                     <td>
                        <xsl:value-of select="artista" />
                     </td>
                     <td>
                        <xsl:value-of select="disco" />
                     </td>
                     <td>
                        <xsl:value-of select="puntuacion" />
                     </td>
                     <xsl:choose>
                        <xsl:when test="disco/@discografica = 'capitol'">
                           <td>LA DISCOGRÁFICA CAPITOL VA A CERRAR!!! MEJOR CAMBIAR</td>
                        </xsl:when>
                        <xsl:otherwise>
                           <td>
                              <xsl:value-of select="disco/@discografica" />
                           </td>
                        </xsl:otherwise>
                     </xsl:choose>
                  </tr>
               </xsl:for-each>

            </table>

            <h2>TABLA 7: Tabla generada con for-each con todos los archivos, con CHOOSE y colorines</h2>

            <table style="border:1px solid blue;">
               <tr style="background-color:lightblue;">
                  <th style="text-align:left">Canción</th>
                  <th style="text-align:left">Artista</th>
                  <th style="text-align:left">Disco</th>
                  <th style="text-align:left">Puntuación</th>
                  <th style="text-align:left">Discográfica</th>
               </tr>

               <xsl:for-each select="//archivo">
                  <xsl:choose>
                     <xsl:when test="puntuacion = 8">
                        <tr style="background-color:yellow">
                           <td><xsl:value-of select="cancion" /></td>
                           <td><xsl:value-of select="artista" /></td>
                           <td><xsl:value-of select="disco" /></td>
                           <td><xsl:value-of select="puntuacion" /></td>
                           <td><xsl:value-of select="disco/@discografica" /></td>
                        </tr>
                     </xsl:when>
                     <xsl:when test="puntuacion = 9">
                        <tr style="background-color:orange">
                           <td><xsl:value-of select="cancion" /></td>
                           <td><xsl:value-of select="artista" /></td>
                           <td><xsl:value-of select="disco" /></td>
                           <td><xsl:value-of select="puntuacion" /></td>
                           <td><xsl:value-of select="disco/@discografica" /></td>
                        </tr>
                     </xsl:when>
                     <xsl:otherwise>
                        <tr style="background-color:pink">
                           <td><xsl:value-of select="cancion" /></td>
                           <td><xsl:value-of select="artista" /></td>
                           <td><xsl:value-of select="disco" /></td>
                           <td><xsl:value-of select="puntuacion" /></td>
                           <td><xsl:value-of select="disco/@discografica" /></td>
                        </tr>
                     </xsl:otherwise>
                  </xsl:choose>
               </xsl:for-each>
            </table>
         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>