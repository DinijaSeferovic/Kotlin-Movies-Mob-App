

package com.example.cinaeste

import FavoriteMoviesFragment
import RecentMoviesFragment
import SearchFragment
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cinaeste.data.Movie
import com.example.cinaeste.view.MovieListAdapter
import com.example.cinaeste.viewmodel.MovieListViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var favoriteMovies: RecyclerView
    private lateinit var favoriteMoviesAdapter: MovieListAdapter
    private lateinit var recentMovies: RecyclerView
    private lateinit var recentMoviesAdapter: MovieListAdapter
    private lateinit var searchText: EditText
    private var movieListViewModel =  MovieListViewModel()
    private val br: BroadcastReceiver = ConnectivityBroadcastReceiver()
    private val filter = IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")

    //Listener za click
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_favorites -> {
                val favoritesFragment = FavoriteMoviesFragment.newInstance()
                openFragment(favoritesFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_recent -> {
                val recentFragments = RecentMoviesFragment.newInstance()
                openFragment(recentFragments)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search -> {
                val searchFragment = SearchFragment.newInstance(" ")
                openFragment(searchFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        /*favoriteMovies = findViewById(R.id.favoriteMovies)
        recentMovies = findViewById(R.id.recentMovies)
        searchText = findViewById(R.id.searchText)*/
        /*favoriteMovies.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
        )
        recentMovies.layoutManager=LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
        )*/
        /*favoriteMoviesAdapter = MovieListAdapter(listOf())
        recentMoviesAdapter = MovieListAdapter((listOf()))*/

        /*favoriteMoviesAdapter = MovieListAdapter(arrayListOf()) { movie -> showMovieDetails(movie) }
        recentMoviesAdapter = MovieListAdapter(arrayListOf()) { movie -> showMovieDetails(movie) }
        favoriteMovies.adapter = favoriteMoviesAdapter
        recentMovies.adapter = recentMoviesAdapter
        favoriteMoviesAdapter.updateMovies(movieListViewModel.getFavoriteMovies())
        recentMoviesAdapter.updateMovies(movieListViewModel.getRecentMovies())*/

        bottomNavigation= findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigation.selectedItemId= R.id.navigation_favorites
        val favoritesFragment = FavoriteMoviesFragment.newInstance()
        openFragment(favoritesFragment)

        if(intent?.action == Intent.ACTION_SEND && intent?.type == "text/plain")
            handleSendText(intent)
    }

    private fun showMovieDetails(movie: Movie) {
        val intent = Intent(this, MovieDetailActivity::class.java).apply {
            putExtra("movie_title", movie.title)
        }
        startActivity(intent)
    }

    /*private fun handleSendText(intent: Intent) {
        intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
            searchText.setText(it)
        }
    }*/

    private fun handleSendText(intent: Intent) {
        intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
            bottomNavigation.selectedItemId= R.id.navigation_search
            val searchFragment = SearchFragment.newInstance(it)
            openFragment(searchFragment)
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(br, filter)
    }

    override fun onPause() {
        unregisterReceiver(br)
        super.onPause()
    }


}