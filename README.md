# Auht3
MITS Auth App

Under Development
<br>
<br>
Completed<br>
1> Biometric with Fallback<br>
2> Device Integrity Checks using RootBeer Libraries(To prevent Mock Location)<br>
3> Location Permissions<br>
4> Intial Geofence(Phase 1) <br>

<br>
<br>
<br>
Basic Story<br>
Intial Survey of Muthoot Surrounding areas have indicated non Uniform Land shape Patterns<br>
That means if one Geo fence is used of a distance 91.6 m from the Main Entrance<br>
(This was done using Google Maps)<br>
It would also account area that is not under Muthoot <br>
This might cause Illegal Authentication of the Students even Without entering the Campus<br>

Update<br>
Modified the Co-ordinates to map an area within 116.6m<br>
Fixes the Geofence Issues<br>
<br>
<br>
<br>
The brute Force Solution<br>
Implement Multiple Geofences<br>
but can slow down the app<br>

<br>
Anyone with ideas?
<br>

Not Done<br>
1> UI <br>
2> Phase 2 Ground Survey of GeoFences<br>
3> Database<br>
<br>
<br>
To run project<br> 
Please run the project in android Studio<br>
<br>1> sync the gradle files to obtain androidx.biometric
<br>2> Then select build variant as debug 
<br>
<br>
<br>Runs on devices from Android 6 to  Android 10
<br>
<br>and also try using Androidx libraries for everything as this ensures compatiability
<br>I might Intergrate Firebase and MongoDB


<br>
Logs:
<br>
Fixed Location Permission and Authentication
