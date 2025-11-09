# 🧭 Katalon Keywords Structure Guide

Struktur ini adalah panduan untuk framework automation profesional berbasis **Katalon Studio**, yang mengimplementasikan prinsip **modular, DRY, dan maintainable**. Semua class dan folder diatur di bawah namespace utama `io.portfolio.*` agar rapi dan mudah dikembangkan.

---

## 📂 Struktur Folder Utama

```
Keywords/
└─ io/
   └─ portfolio/
      ├─ api/
      ├─ core/
      ├─ data/
      ├─ db/
      ├─ flows/
      ├─ hooks/
      ├─ model/
      ├─ pages/
      ├─ reporting/
      ├─ security/
      └─ testrail/
```

---

## 📦 Penjelasan Tiap Package

### 1️⃣ `io.portfolio.api`
**Fungsi:** Menyimpan class untuk request API dan validasi response/schema.  
**Gunanya:** Menyatukan logic REST API di satu tempat (misal PetClinic, DummyAPI.io, dsb.)

**Contoh:**
```groovy
class PetClinicApi {
    static Response getOwners() { ... }
    static Response createOwner(Map body) { ... }
}
```

---

### 2️⃣ `io.portfolio.core`
**Fungsi:** Tempat helper universal yang digunakan di Web/API/Mobile/DB.  
**Gunanya:** Pondasi framework — semua keyword teknis utama disimpan di sini.

**Contoh file:** `WebHelpers.groovy`, `ApiClient.groovy`, `DbClient.groovy`, `WaitUtils.groovy`

**Contoh:**
```groovy
class WebHelpers {
    static void clickSmart(TestObject to) {
        WebUI.waitForElementClickable(to, GlobalVariable.TIMEOUT)
        WebUI.click(to)
    }
}
```

---

### 3️⃣ `io.portfolio.data`
**Fungsi:** Generator dan pengelola data test.  
**Gunanya:** Membuat data dinamis, membaca file eksternal, atau membuat dummy data.

**Contoh:**
```groovy
class DataGenerator {
    static Map randomOwner() {
        return [firstName: 'John', lastName: 'Doe', city: 'NY']
    }
}
```

---

### 4️⃣ `io.portfolio.db`
**Fungsi:** Koneksi dan query database.  
**Gunanya:** Validasi hasil test dari API/UI ke DB.

**Contoh:**
```groovy
class DbClient {
    static List<Map> query(String sql) { ... }
}
```

---

### 5️⃣ `io.portfolio.flows`
**Fungsi:** Menyimpan business flow reusable.  
**Gunanya:** Menyatukan step panjang (login, checkout, dsb.) agar test case tetap ringkas.

**Contoh:**
```groovy
class LoginFlow {
    static void login(String user, String pass) {
        LoginPage.open()
        LoginPage.setUsername(user)
        LoginPage.setPassword(pass)
        LoginPage.clickLogin()
    }
}
```

---

### 6️⃣ `io.portfolio.hooks`
**Fungsi:** Listener dan inisialisasi suite.  
**Gunanya:** Jalankan setup otomatis (seed data, clean-up, integrasi TestRail).

**Contoh:**
```groovy
class SuiteHook {
    @BeforeTestSuite
    def setupSuite(TestSuiteContext ctx) { ... }
}
```

---

### 7️⃣ `io.portfolio.model`
**Fungsi:** POJO (Plain Old Java Object) untuk representasi data.  
**Gunanya:** Representasi entity dari API atau DB.

**Contoh:**
```groovy
class Owner {
    String firstName
    String lastName
    String city
}
```

---

### 8️⃣ `io.portfolio.pages`
**Fungsi:** Page Object Model (POM) untuk Web.  
**Gunanya:** Memisahkan locator & aksi halaman dari test case.

**Contoh:**
```groovy
class LoginPage {
    static def fldUser = OR.findTestObject('Login/txt_Username')
    static def fldPass = OR.findTestObject('Login/txt_Password')

    static void open() { WebUI.navigateToUrl('https://demo-app/login') }
    static void setUsername(String val) { WebUI.setText(fldUser, val) }
    static void setPassword(String val) { WebUI.setEncryptedText(fldPass, val) }
}
```

---

### 9️⃣ `io.portfolio.reporting`
**Fungsi:** Logging, screenshot, dan report custom.  
**Gunanya:** Memberi bukti visual & laporan hasil test.

**Contoh:**
```groovy
class ScreenshotManager {
    static void capture(String name) {
        WebUI.takeScreenshot("Reports/${name}_${System.currentTimeMillis()}.png")
    }
}
```

---

### 🔟 `io.portfolio.security`
**Fungsi:** Fungsi keamanan (encrypt, masking, token validator).  
**Gunanya:** Melindungi data sensitif dari log/report.

**Contoh:**
```groovy
class EncryptUtility {
    static String encrypt(String plain) { return WebUI.encrypt(plain) }
}
```

---

### 11️⃣ `io.portfolio.testrail`
**Fungsi:** Integrasi ke TestRail API.  
**Gunanya:** Buat run otomatis dan push hasil test ke TestRail.

**Contoh:**
```groovy
class TestRailClient {
    static Map post(String path, Map body) { ... }
}
```

---

## 📘 Ringkasan
| Package | Fungsi Utama | Contoh File |
|----------|---------------|-------------|
| `api` | Endpoint test & schema validation | `PetClinicApi.groovy` |
| `core` | Helper inti (Web/API/DB utils) | `WebHelpers.groovy` |
| `data` | Generator/loader data | `DataGenerator.groovy` |
| `db` | Query DB & validasi | `DbClient.groovy` |
| `flows` | Business flow reusable | `LoginFlow.groovy` |
| `hooks` | Listener setup/teardown | `SuiteHook.groovy` |
| `model` | POJO/entity | `Owner.groovy` |
| `pages` | Page Object Model | `LoginPage.groovy` |
| `reporting` | Screenshot & log | `ScreenshotManager.groovy` |
| `security` | Encrypt/masking | `EncryptUtility.groovy` |
| `testrail` | Integrasi TestRail | `TestRailClient.groovy` |

---

## 🧠 Tips Implementasi
- Gunakan **namespace singkat & konsisten** (`io.portfolio` cocok untuk portfolio pribadi).
- Hindari `(default package)` — selalu pakai `package io.portfolio.xxx`.
- Setiap folder punya class minimal 1 file.
- Buat test suite terpisah per domain (UI, API, DB) agar pipeline bisa paralel.

---

✅ **Tujuan akhir:**
Framework modular, mudah dibaca, siap CI/CD, dan scalable untuk Web, API, Mobile, dan DB testing secara bersamaan.