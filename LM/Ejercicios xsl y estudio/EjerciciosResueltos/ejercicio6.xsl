<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
   <xsl:template match="/">
      <html>
         <body>
            <h1>
               <xsl:value-of select="universidad/nombre" />
            </h1>
            <h2>
               Informe de notas finales
               <xsl:value-of select="universidad/curso" />
            </h2>

            <table border="1">

               <tr>
                  <th>FOTO</th>
                  <th>PRIMER APELLIDO</th>
                  <th>NOMBRE</th>
                  <th>CARRERA</th>
                  <th>NUM ASIGNATURAS</th>
                  <th>ASIGNATURAS</th>
               </tr>

               <!-- TABLA CON INFORMACIÓN DE SOLO LOS ALUMNOS DEL MISMO SEXO QUE RIVAS (Primer apellido)-->
               <!-- también se puede hacer con variables -->
               <xsl:for-each select="//alumno[sexo = //alumno[contains(apellido1,'Rivas')]/sexo]">
               <!--<xsl:for-each select="universidad/alumnos/alumno">-->
                  <tr>
                     <td>
                        <img src="imagenes/{@avatar}" />
                     </td>
                     <td><xsl:value-of select="apellido1"/></td>
                     <td><xsl:value-of select="nombre"/></td>
                     <td>
                        
                        <xsl:variable name="codCarrera" select="estudios/carrera/@codigo"/>   
                        <xsl:value-of select="//carrera[@id=$codCarrera]/nombre"/>
                        <!--
                        <xsl:value-of select="../../carreras/carrera[@id=//estudios/carrera/@codigo]/nombre"/>
                        -->
                           
                     </td>
                     <td><xsl:value-of select="count(estudios/asignaturas/asignatura)"/></td>
                     <td>
                        <ul>
                           <xsl:for-each select="estudios/asignaturas/asignatura">
                              <xsl:variable name="codAsig" select="@codigo"/>
                              
                                 <li>
                                    <xsl:value-of select="//asignaturas/asignatura[@id = $codAsig]/nombre"/>
                                    <xsl:if test="@final &gt;= 5">[APROBADO]</xsl:if>
                                    <xsl:if test="@final &lt; 5">[SUSPENSO]</xsl:if>
                                 </li>

                           </xsl:for-each>
                        </ul>
                     </td>
                  </tr>
               </xsl:for-each>

            </table>

         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>