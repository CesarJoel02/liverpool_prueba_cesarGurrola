package com.cesargurrola.liverpool_shopapp.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cesargurrola.liverpool_shopapp.R
import com.cesargurrola.liverpool_shopapp.adapters.ProductAdapter
import com.cesargurrola.liverpool_shopapp.databinding.FragmentMainBinding
import com.cesargurrola.liverpool_shopapp.viewModel.ProductViewModel

class MainFragment : Fragment() {

    private lateinit var viewModel: ProductViewModel
    private lateinit var productAdapter: ProductAdapter
    private lateinit var binding : FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.filtro, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.predef -> {

                return true
            }
            R.id.min -> {

                return true
            }

            R.id.max -> {

                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        productAdapter = ProductAdapter()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = productAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val lastVisibleItemPosition = (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                    if (lastVisibleItemPosition == productAdapter.itemCount - 1) {
                        viewModel.nextPage(binding.searchEditText.text.toString())
                    }
                }
            })
        }

        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString()
            viewModel.searchProducts(query)

        }

        viewModel.products.observe(viewLifecycleOwner) { products ->
            productAdapter.submitList(products)
        }
        return binding.root
    }
}