plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.studyapplication"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.studyapplication"
        minSdk = 31
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("io.github.scwang90:refresh-layout-kernel:2.0.6")      //核心必须依赖
    implementation("io.github.scwang90:refresh-header-classics:2.0.6")    //经典刷新头
    implementation("io.github.scwang90:refresh-header-radar:2.0.6")       //雷达刷新头
    implementation("io.github.scwang90:refresh-header-falsify:2.0.6")     //虚拟刷新头
    implementation("io.github.scwang90:refresh-header-material:2.0.6")    //谷歌刷新头
    implementation("io.github.scwang90:refresh-header-two-level:2.0.6")   //二级刷新头
    implementation("io.github.scwang90:refresh-footer-ball:2.0.6")        //球脉冲加载
    implementation("io.github.scwang90:refresh-footer-classics:2.0.6")    //经典加载

    implementation("androidx.recyclerview:recyclerview:1.2.1")  //recyclerview加载列表

    implementation("de.hdodenhof:circleimageview:3.1.0")  //circleimageview


    implementation("com.github.bumptech.glide:glide:4.11.0") //glide框架
    annotationProcessor("com.github.bumptech.glide:compiler:4.11.0")

    implementation("com.squareup.okhttp3:okhttp:4.9.3") //okhttp框架

    implementation("com.google.code.gson:gson:2.8.6")// gson框架

    implementation ("androidx.room:room-runtime:2.2.5")  //room数据库底层 是sqlite
    annotationProcessor("androidx.room:room-compiler:2.2.5")

    implementation("io.reactivex.rxjava3:rxjava:3.0.4") //rx框架
    implementation("io.reactivex.rxjava3:rxandroid:3.0.0")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}