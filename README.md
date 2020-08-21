# Auht3
MITS Auth App
<br>
Flaws are Bleeding
<br>
Under Development
<br>
<br>
Completed<br>
1> Biometric with Fallback<br>
2> Device Integrity Checks using RootBeer Libraries(To prevent Mock Location)<br>
3> Location Permissions<br>
4> Geofence Completed<br>
5>Database Phase 1<br>(Parameter collection)

<br>
<br>
<br>
Key Vulnerability<br>
<br>
Time is a funtion of this app.This measures the success  of the app.<br>
<br>
<br>
<br>
Applications available on the Playstore have time vulnerability<br>
Let us say an app is based on a Trial Basis,then the functions of the app terminate as soon as the trial is approached..<br>
<br>
<br>
A cool way to manipulate the trial is to change the System time when ever the app is in usage.This fools the internal trial function as it depends on System time<br>
<br>
<br>
<br>
<br>
Another thing is the TimeStamp<br> 
-Either UNIX Epoch Time<br>
-SHA-256 Generated Hash<br>
This prevents the faking of time.<br>
<br>
<br>
Not Done<br>
1> UI <br>
2>Task Scheduling<br>
3> Deploying Database<br>
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
<br>and also try using Androidx libraries for everything as this ensures compatiability<br>
Integrated MongoDB
