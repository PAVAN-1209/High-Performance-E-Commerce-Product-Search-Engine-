High-Performance E-Commerce Product Search Engine

A high-performance, in-memory product search engine designed to solve the computational bottlenecks of traditional e-commerce retrieval systems. By leveraging a custom hybrid data structure approach, this engine provides sub-millisecond query latency for complex, multi-dimensional product searches without relying on heavy external databases.

Note: For a comprehensive academic analysis, theoretical background, complexity evaluation, and extended test cases, please refer to the official project report: "DSA Capstone Report (2).docx".

📖 Overview

Modern e-commerce platforms struggle with "Hybrid Queries"—searches that combine text prefixes (like autocomplete) with numeric constraints (like price ranges and ratings). Traditional databases use inverted indices that consume massive amounts of RAM and suffer from high overhead during continuous inventory updates.

This project transitions the retrieval challenge into a purely algorithmic optimization challenge using:

Compressed Trie: For lightning-fast, memory-efficient string prefix matching.

Hybrid Fusion Tree (Tree-based indexing): For rapid, logarithmic-time numeric range processing.

✨ Key Features

Instant Autocomplete & Prefix Search: Sub-millisecond retrieval of products sharing a text prefix, independent of the total catalog size.

Multi-Attribute Filtering: Seamlessly filter products by Brand, Category, Price Range, and Minimum Rating simultaneously.

Top-K Retrieval: Automatically sorts and returns the highest-rated products matching the search criteria.

Dynamic Inventory Updates: Update product stock in real-time ($O(1)$ time complexity) without triggering expensive database segment merges or re-indexing.

Zero-Dependency Server: Includes a lightweight HTTP API Gateway powered by Java's native HttpServer.

🧠 Data Structures and Algorithms

Compressed Trie: Replaces standard text indexing. By collapsing redundant character nodes, it drastically reduces memory consumption and pointer traversals, ensuring $O(P)$ prefix search time (where $P$ is the prefix length).

Hybrid Fusion Tree Index (TreeMap): Decouples numeric filtering from text intelligence. It narrows down price and rating bounds in $O(\log N + K)$ time, avoiding standard array linear scans.

HashSets / HashMaps: Acts as the central product catalog registry, providing $O(1)$ retrieval of full product objects once candidate IDs are identified by the Trie or Tree.

Top-K Sorting: Utilizes comparator-based sorting on the filtered subset to extract the most relevant results.

📂 Project Structure

Product.java: Data encapsulation class storing core product attributes (ID, name, brand, category, price, rating, stock).

CompressedTrie.java: Custom Trie implementation handling character-node mapping and ID aggregation for text search.

FusionTreeIndex.java: Tree-based indexing handling numeric boundary logic.

SearchEngine.java: The core orchestrator that synchronizes the Trie, Tree, and HashMap to execute hybrid queries.

WebServer.java: Binds the Java backend to port 8080 to serve the web interface.

Main.java: CLI entry point for testing basic engine functionality and stock updates.

web/index.html: The frontend user interface (Vanilla HTML/JS/CSS).

🚀 Getting Started

Prerequisites

Java SE Runtime Environment (JRE) 17 or higher.

An IDE like IntelliJ IDEA or Eclipse (optional, for development).

Installation & Execution

Clone the repository:

git clone https://github.com/yourusername/ecommerce-search-engine.git
cd ecommerce-search-engine


Compile the Java files:

javac *.java


Run the CLI Demo:

java Main


Run the Web Server:

java WebServer


Once the server starts, open your web browser and navigate to: http://localhost:8080

⏱️ Complexity Analysis

Operation

Best Case

Average Case

Worst Case

Space Complexity

Trie Insertion

$O(L)$

$O(L)$

$O(L)$

$O(N \times L)$

Trie Prefix Search

$O(1)$

$O(P)$

$O(P)$

$O(1)$ auxiliary

Tree Range Search

$O(1)$

$O(\log N + K)$

$O(\log N + K)$

$O(1)$ auxiliary

Hybrid Filter

$O(P)$

$O(P + K)$

$O(P + N)$

$O(K)$

(Where $N$ = Total products, $L$ = Word length, $P$ = Query prefix length, $K$ = Matching products)

👥 Contributors

This project was developed as a Capstone for Data Structures and Algorithms 2 (22AIE203) at Amrita School of Engineering, Chennai Campus (Academic Year 2025-29).

Raghu Kishore (CH.SC.U4AIE25036)

Pavan Sai (CH.SC.U4AIE25043)

Haniketh (CH.SC.U4AIE25063)

Venkateswar (CH.SC.U4AIE25067)

Project Guide: Dr. G. Bharati Mohan

Built with optimized algorithms for the modern digital economy.
