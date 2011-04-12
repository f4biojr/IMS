/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function shellScript(ip,porta){<% String[] cmd = {"/bin/sh", "-c", "ssh -p " + porta + " " + ip}; Runtime.getRuntime().exec(cmd); %>}
