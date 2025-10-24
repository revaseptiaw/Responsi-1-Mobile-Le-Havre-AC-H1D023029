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

### Penjelasan Alur Data dari Pemanggilan API hingga Penyajian di Layar
1. Pemanggilan API (Network Layer)

Pada tahap awal, aplikasi melakukan proses pengambilan data dari server menggunakan Retrofit, yaitu library populer untuk komunikasi API berbasis HTTP.

File yang berperan dalam tahap ini adalah:

FootballApiService → berisi daftar endpoint API yang digunakan untuk mengambil data (misalnya data tim, pelatih, atau pemain).

ApiClient → mengatur konfigurasi koneksi seperti base URL dan converter untuk mengubah data dari format JSON menjadi objek Kotlin.

Tahap ini memastikan aplikasi dapat berkomunikasi dengan server dan meminta data yang dibutuhkan secara efisien.

2. Pengolahan Data dari API (Model Layer)

Setelah aplikasi menerima data dari server, datanya masih berbentuk JSON mentah.
Agar dapat digunakan di dalam aplikasi, data tersebut dikonversi menjadi objek model melalui Model Layer.

Model diwakili oleh file:

TeamResponse.kt → berfungsi sebagai template untuk menyimpan data yang diterima dari server seperti nama tim, logo, pelatih, dan daftar pemain.

Dengan adanya model, data menjadi lebih mudah diolah, disimpan, dan ditampilkan ke pengguna.

3. Pengelolaan Data (Repository Layer)

Tahap selanjutnya adalah pengelolaan data di dalam FootballRepository.

Repository berfungsi sebagai penghubung antara API dan ViewModel.
Ketika aplikasi membutuhkan data, ViewModel tidak langsung memanggil API, tetapi akan meminta data melalui Repository.

Repository kemudian akan menentukan apakah data harus diambil dari:

Internet (API), atau

Sumber lokal (misalnya cache atau database, jika ada).

Dengan demikian, Repository bertindak sebagai Single Source of Truth, menjaga agar data di aplikasi tetap konsisten.

4. Manajemen Data dan Lifecycle (ViewModel Layer)

Setelah Repository mendapatkan data dari API, data tersebut dikirim ke FootballViewModel.

ViewModel bertanggung jawab untuk:

Menyimpan dan mengelola data agar tetap bertahan meskipun terjadi perubahan UI (misalnya rotasi layar).

Menyediakan data ke UI melalui LiveData, yaitu variabel yang bisa diamati (observable).

Setiap kali isi LiveData berubah, UI akan otomatis diperbarui tanpa perlu pemanggilan ulang secara manual oleh developer.
Hasilnya, aplikasi menjadi lebih responsif dan hemat sumber daya.

5. Penyajian Data ke Layar (View Layer – Activity & Fragment)

Data yang telah disiapkan oleh ViewModel kemudian diamati oleh berbagai komponen UI, seperti:

TeamSquadActivity

ClubHistoryActivity

HeadCoachActivity

Saat ViewModel mengirimkan data baru, komponen UI ini langsung menampilkan informasi di layar.
Activity tidak perlu lagi menulis ulang logika pemanggilan API karena semuanya sudah ditangani di ViewModel dan Repository.

Tahap ini bertanggung jawab penuh untuk menyajikan data dalam bentuk tampilan yang mudah dipahami pengguna.

6. Tampilan Akhir di UI (Adapter dan Layout XML)

Tahap terakhir adalah penyajian data dalam bentuk tampilan visual interaktif.

Data yang diterima dari ViewModel akan diteruskan ke Adapter, misalnya PlayerAdapter, yang bertugas menampilkan data dalam RecyclerView.
Setiap elemen data (nama pemain, posisi, dan gambar) ditampilkan menggunakan layout XML, seperti item_player.xml.

Dengan pendekatan ini, setiap komponen di layar memiliki desain yang konsisten, rapi, dan mudah diubah sesuai kebutuhan tampilan.
