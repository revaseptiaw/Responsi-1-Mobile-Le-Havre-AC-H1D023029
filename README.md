# Responsi-1-Mobile-Le-Havre-AC-H1D023029
Aplikasi Android yang menampilkan informasi klub sepak bola Le Havre AC, termasuk sejarah klub, pelatih kepala, dan daftar pemain (team squad).
Aplikasi ini menggunakan arsitektur MVVM (Model-View-ViewModel) dengan Repository Pattern serta Retrofit untuk pengambilan data dari API.

## Identitas
- Nama: Reva Septia Wulandari  
- NIM: H1D023029  
- Shift Baru: F
- Shift Asal: D

## Tampilan Aplikasi
![Image](https://github.com/user-attachments/assets/3968a60e-7f30-45c1-bb73-8dd66dc85cec)

# Penjelasan Alur Data dari Pemanggilan API hingga Penyajian di Layar

## 1. Pemanggilan API (Network Layer)

Tahap awal dimulai dengan proses pengambilan data dari server menggunakan Retrofit, yaitu library populer untuk komunikasi API berbasis HTTP.

File yang berperan dalam tahap ini:
- FootballApiService → Berisi daftar endpoint API yang digunakan untuk mengambil data, seperti daftar tim, pelatih, dan pemain.
- ApiClient → Mengatur konfigurasi koneksi seperti baseUrl dan converter factory (GsonConverterFactory) untuk mengubah data JSON menjadi objek Kotlin.

Tahap ini memastikan aplikasi dapat berkomunikasi dengan server dan meminta data yang dibutuhkan secara efisien.

## 2. Pengolahan Data dari API (Model Layer)

Setelah aplikasi menerima data dari server, datanya masih berupa JSON mentah. Agar bisa digunakan di aplikasi, data tersebut dikonversi menjadi objek model melalui Model Layer.

Model utama yang digunakan:
- TeamResponse.kt, yang terdiri dari tiga bagian penting:
  - TeamResponse → Menyimpan data utama tim seperti id, name, shortName, crest, coach, dan squad.
  - Coach → Menyimpan data pelatih (id, name, nationality, dateOfBirth).
  - Player → Menyimpan data pemain (id, name, position, nationality, dateOfBirth). Model ini menggunakan anotasi @Parcelize agar bisa dikirim antar Activity atau Fragment.

## 3. Pengelolaan Data (Repository Layer)

Lapisan berikutnya adalah FootballRepository, yang berfungsi sebagai penghubung antara API dan ViewModel.

Peran utama Repository:
- Mengatur logika pengambilan data, baik dari API (Retrofit) maupun dari sumber lokal.
- Menyediakan data yang sudah siap digunakan oleh ViewModel.

Repository berperan sebagai Single Source of Truth, memastikan data yang disediakan selalu konsisten dan terpusat di seluruh bagian aplikasi.

## 4. Manajemen Data dan Lifecycle (ViewModel Layer)

Setelah Repository memperoleh data dari API, data tersebut dikirim ke FootballViewModel.

Fungsi ViewModel:
- Menyimpan dan mengelola data agar tetap bertahan meskipun terjadi perubahan konfigurasi seperti rotasi layar.
- Menyediakan data ke UI melalui LiveData, objek yang dapat diamati (observable).

Ketika LiveData berubah, UI akan otomatis diperbarui tanpa perlu pemanggilan ulang manual, membuat aplikasi lebih responsif dan efisien.

## 5. Penyajian Data ke Layar (View Layer – Activity & Fragment)

Data yang telah dikelola oleh ViewModel diamati oleh berbagai komponen UI seperti:
- TeamSquadActivity
- ClubHistoryActivity
- HeadCoachActivity

Komponen UI ini akan memperbarui tampilan secara otomatis ketika data pada ViewModel berubah. Dengan arsitektur MVVM, Activity tidak perlu memanggil API secara langsung karena seluruh proses sudah dikelola oleh Repository dan ViewModel. Hasilnya, kode menjadi lebih bersih dan mudah dirawat.

## 6. Tampilan Akhir di UI (Adapter & Layout XML)

Tahap terakhir adalah penyajian data ke pengguna melalui tampilan interaktif.

Komponen utama:
- PlayerAdapter → Bertugas menampilkan data pemain ke dalam RecyclerView.
- item_player.xml → Mengatur tampilan tiap item seperti nama pemain, posisi, dan gambar profil.

Dengan pendekatan ini, tampilan data menjadi dinamis, konsisten, dan mudah disesuaikan dengan kebutuhan desain aplikasi.
