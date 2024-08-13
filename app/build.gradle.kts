plugins {
    id("com.android.application")

    // Add the Google services Gradle plugin
    id("com.google.gms.google-services")

    //NOTE to self using gmail account: meahabul27@gmail.com

}

android {
    namespace = "com.example.osjcttwo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.osjcttwo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    //Had to use (" ") to replace '
    //Comment completion doesn't always work

    // Use this dependency to bundle the model with your app
    implementation ("com.google.mlkit:barcode-scanning:17.2.0")

      // ...
        // Use this dependency to use the dynamically downloaded model in Google Play Services
    implementation ("com.google.android.gms:play-services-mlkit-barcode-scanning:18.3.0")

    //def camerax_version = "1.2.2"
    implementation ("androidx.camera:camera-core:1.3.4")
    implementation ("androidx.camera:camera-camera2:1.3.4")
    implementation ("androidx.camera:camera-lifecycle:1.3.4")
    implementation ("androidx.camera:camera-video:1.3.4")

    implementation ("androidx.camera:camera-view:1.3.4")
    implementation ("androidx.camera:camera-extensions:1.3.4")

    //Zxing Android: https://www.youtube.com/watch?v=jtT60yFPelI
    implementation ("com.journeyapps:zxing-android-embedded:4.3.0")

    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))


    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")

    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-database")

    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-database")

    //https://www.youtube.com/watch?v=pOKPQ8rYe6g&t=346s
    //Google Maps
    //AIzaSyCgQdY5-KNkZtmpU1KhvqoSdKWcPD-yt_M
    implementation("com.google.android.gms:play-services-maps:18.1.0")





}



