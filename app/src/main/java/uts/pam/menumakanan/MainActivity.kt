package uts.pam.menumakanan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uts.pam.menumakanan.ui.theme.MenuMakananTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MenuMakananTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WelcomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    Box(
    modifier = modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(16.dp),
    contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Selamat Datang di Aplikasi Makanan",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Pesan makanan favoritmu !",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = "Pesan Makanan !",
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    MenuMakananTheme {
        WelcomeScreen()
    }
}

@Composable
fun AuthScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.weight(0.5f))

        Text(
            text = "Sign Up",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Unlock the world's finest dish with the most intuitive spirit-lifting app",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black
            )
                ){
                    Text(
                        text = "Register",
                        fontWeight = FontWeight.Bold
                    )
                }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black
            )
        ){
            Text(
                text = "Login",
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AuthScreenPreview(){
    MenuMakananTheme {
        AuthScreen()
    }
}

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    var fullName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Register",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black
            )
        ) {
            Text(
                text = "Register",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview(){
    MenuMakananTheme {
        RegisterScreen()
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Login",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black
            )
        ){
            Text(
                text = "Login",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview(){
    MenuMakananTheme {
        LoginScreen()
    }
}

data class MenuItem(val id: Int, val name: String, val price: Double, val imageUrl: String)

fun listMenuItems(): List<MenuItem> {
    return listOf(
        MenuItem(1, "Cheesecake", 45000.0, "https://images.unsplash.com/photo-1565792595384-3cb31b28531c?q=80&w=800"),
        MenuItem(2, "Tiramisu", 55000.0, "https://images.unsplash.com/photo-1571877232378-de54b528731e?q=80&w=800"),
        MenuItem(3, "Red Velvet Cake", 48000.0, "https://images.unsplash.com/photo-1616541823720-4a692131a4a2?q=80&w=800"),
        MenuItem(4, "Macarons (box)", 65000.0, "https://images.unsplash.com/photo-1558326567-98ae2405596b?q=80&w=800"),
        MenuItem(5, "Panna Cotta", 42000.0, "https://images.unsplash.com/photo-1549488344-cbb6c34cf08b?q=80&w=800"),
        MenuItem(6, "Molten Lava Cake", 52000.0, "https://images.unsplash.com/photo-1618334812359-54f4a9c33672?q=80&w=800"),
        MenuItem(7, "Fudgy Brownies", 38000.0, "https://images.unsplash.com/photo-1606890246220-48135882e34a?q=80&w=800"),
        MenuItem(8, "Classic Apple Pie", 50000.0, "https://images.unsplash.com/photo-1599937395029-73b320794c8e?q=80&w=800"),
        MenuItem(9, "Strawberry Croissant", 35000.0, "https://images.unsplash.com/photo-1568461793229-0733e53315a7?q=80&w=800"),
        MenuItem(10, "Belgian Waffle", 58000.0, "https://images.unsplash.com/photo-1562376552-0d160a2f8394?q=80&w=800"),
        MenuItem(11, "Crème Brûlée", 47000.0, "https://images.unsplash.com/photo-1628218944322-1fac29245763?q=80&w=800"),
        MenuItem(12, "Lemon Meringue", 46000.0, "https://images.unsplash.com/photo-1627485743603-1c3f2b8423d2?q=80&w=800"),
        MenuItem(13, "Mochi Ice Cream", 33000.0, "https://images.unsplash.com/photo-1615413349469-0a6a7c3f3f33?q=80&w=800"),
        MenuItem(14, "Churros", 40000.0, "https://images.unsplash.com/photo-1582293041079-7814c2f63ba3?q=80&w=800"),
        MenuItem(15, "Donuts (box)", 60000.0, "https://images.unsplash.com/photo-1551106652-a5bcf4b29ab6?q=80&w=800"),
        MenuItem(16, "Pancakes", 43000.0, "https://images.unsplash.com/photo-1567620905732-2d1ec7ab7445?q=80&w=800")
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, fullName: String = "Julay"){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Halo, $fullName") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Yellow,
                    titleContentColor = Color.Black
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Yellow,
                contentColor = Color.Black
            ) {
                IconButton(onClick = {/*todo*/ }, modifier = Modifier.weight(1f)) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Keranjang")
                        Text("Keranjang", fontSize = 12.sp)
                    }
                }
                IconButton(onClick = {/*todo*/ }, modifier = Modifier.weight(1f)) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.Home, contentDescription = "Home")
                        Text("Home", fontSize = 12.sp)
                    }
                }
                IconButton(onClick = {/*todo*/ }, modifier = Modifier.weight(1f)) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.Person, contentDescription = "Profile")
                        Text("Profile", fontSize = 12.sp)
                    }
                }
            }
        }
    ){
        innerPadding ->
        val menuItems = listMenuItems()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(menuItems) { item ->
                MenuItemCard(menuItem = item)
            }
        }
    }
}

@Composable
fun MenuItemCard(menuItem: MenuItem, modifier: Modifier = Modifier){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            AsyncImage(
                model = menuItem.imageUrl,
                contentDescription = menuItem.name,
                modifier = Modifier
                    .fillMaxSize()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = menuItem.name,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
            )
            Text(
                text = "Rp. ${"%,.0f".format(menuItem.price)}",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black
                )
            ){
                Text(
                    text = "+ Keranjang",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    MenuMakananTheme {
        HomeScreen()
    }
}

@Composable
fun ProfileScreen(
    modifier : Modifier = Modifier,
    fullName: String,
    username: String
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            imageVector = Icons.Default.Person,
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = fullName,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "@$username",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black
            )
        ){
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit Icon",
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "Edit Profile",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black
                )
            ){
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Logout Icon",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "Logout",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview(){
    MenuMakananTheme {
        ProfileScreen(
            fullName = "Muhammad Agung Julyansyah",
            username = "julay"
        )
    }
}

data class CartItem(val menuItem: MenuItem, val quantity: Int)

fun listCartItems(): List<CartItem> {
    val menuItems = listMenuItems()
    return listOf(
        CartItem(menuItems[0], 2),
        CartItem(menuItems[2], 1),
        CartItem(menuItems[5], 3)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(modifier: Modifier = Modifier) {
    val cartItems = listCartItems()
    val totalPrice = cartItems.sumOf { it.menuItem.price * it.quantity }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Keranjang Saya") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Yellow,
                    titleContentColor = Color.Black
                )
            )
        },
        bottomBar = {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Total Harga:", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text("Rp ${"%,.0f".format(totalPrice)}", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* TODO: Navigasi ke halaman Checkout */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Black
                    )
                ) {
                    Text("Checkout", fontWeight = FontWeight.Bold)
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(cartItems) { cartItem ->
                CartItemRow(cartItem = cartItem)
            }
        }
    }
}

@Composable
fun CartItemRow(cartItem: CartItem) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(cartItem.menuItem.name, fontWeight = FontWeight.Bold)
            Text("Rp ${"%,.0f".format(cartItem.menuItem.price)}", color = Color.Gray)
        }
        Text("x${cartItem.quantity}", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OrderScreenPreview() {
    MenuMakananTheme {
        OrderScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutScreen(modifier: Modifier = Modifier) {
    var namaLengkap by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var nomorTelepon by remember { mutableStateOf("") }

    val paymentOptions = listOf("QRIS", "Cash")
    var selectedPayment by remember { mutableStateOf(paymentOptions[0]) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Alamat Pengiriman") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Yellow,
                    titleContentColor = Color.Black
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text("Isi Detail Pengiriman:", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = namaLengkap,
                onValueChange = { namaLengkap = it },
                label = { Text("Nama Lengkap") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = { Text("Alamat Lengkap") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = nomorTelepon,
                onValueChange = { nomorTelepon = it },
                label = { Text("Nomor Telepon") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))

            Text("Metode Pembayaran:", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            paymentOptions.forEach { option ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (option == selectedPayment),
                            onClick = { selectedPayment = option }
                        )
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (option == selectedPayment),
                        onClick = { selectedPayment = option }
                    )
                    Text(
                        text = option,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { /* TODO: Navigasi ke ThankYouScreen */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black
                )
            ) {
                Text("Pesan Sekarang", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CheckoutScreenPreview() {
    MenuMakananTheme {
        CheckoutScreen()
    }
}

@Composable
fun ThankYouScreen(modifier: Modifier = Modifier, fullName: String) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart, // Contoh ikon
            contentDescription = "Order Success",
            modifier = Modifier.size(100.dp),
            tint = Color(0xFF00C853) // Warna hijau sukses
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Terima kasih, $fullName!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Pesanan Anda akan segera kami proses.\nMohon ditunggu, ya!",
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /* TODO: Navigasi kembali ke HomeScreen */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black
            )
        ) {
            Text("Kembali ke Menu", fontWeight = FontWeight.Bold)
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ThankYouScreenPreview() {
    MenuMakananTheme {
        ThankYouScreen(fullName = "Agung Julyansyah")
    }
}


