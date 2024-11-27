<h1 align="center">Web-scrapper for <a href="https://books.toscrape.com">Books to Scrape</h1>

<h2>Project Overview</h2>
This project is a book scraper and saver application designed as part of a test assignment. The application scrapes book information from a specified URL, processes the data, and saves it into a database. It supports pagination, allowing you to scrape a page by passing an optional page number parameter.

<h2>Technologies Used</h2>
<ul>
    <li><strong>Programming Language</strong>: Java 17</li>
    <li><strong>Framework</strong>: Spring Boot, Spring Web</li>
    <li><strong>Data Persistence</strong>: Spring Data JPA</li>
    <li><strong>Web Scraping</strong>: Custom scrapper service</li>
    <li><strong>Database</strong>: PostgreSQL (for storing book data)</li>
</ul>

<h2>Prerequisites</h2>
<p>To run the project, you need the following:</p> <ul> 
  <li>Java 17+</li> <li>PostgreSQL (or another SQL database of your choice)</li> 
  <li>Maven for dependency management</li> </ul>

  <h2>Installation and Setup</h2>
<ol> <li><strong>Clone the repository</strong>: <pre><code>git clone https://github.com/murkeev/scrapper.git</code></pre> </li>
<li><strong>Update credentials</strong>: Open the <code>application.properties</code> file and insert your database:<br></br>
<pre><code>spring.datasource.driver-class-name=${DB_DRIVER_CLASS_NAME}
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=${HIBERNATE_DDL_AUTO}
</code></pre></li>
<li><strong>Run the project</strong>: Use your preferred method (e.g., IDE or terminal) to build and run the application.</li>
</ol>

<h2>Usage</h2>
<h3>Scraping Books</h3>
<p>
    To scrape books, send a <strong>GET</strong> request to the API endpoint using Postman or another API client. 
    You need to provide the base URL of the book listing and an optional <code>pageNumber</code> parameter. 
    If <code>pageNumber</code> is not provided, it defaults to <strong>1</strong>.
</p>
<h4>Endpoint</h4>
<pre>
<code>
GET /api/v1/scrapper/scrape
</code>
</pre>

<h4>Request Param</h4>
<pre>
<code>
{
    "url": "https://books.toscrape.com/catalogue/category/books_1", // use only this link for scrape
    "pageNumber": 2 // optional
}
</code>
</pre>

<ul>
    <li><strong>url</strong>: The base URL of the book listing (required).</li>
    <li><strong>pageNumber</strong>: The page number to scrape (optional, defaults to <code>1</code>).</li>
</ul>

<h4>Example Request in Postman</h4>
<p>
    To scrape the first page:
</p>
<pre>
<code>
GET /api/v1/scrapper/scrape
Content-Type: application/json

{
    "url": "https://books.toscrape.com/catalogue/category/books_1"
}
</code>
</pre>

<h4>Response</h4>
<p>
    The API will return a status code indicating success or failure.
</p>
<h3>Repository</h3>
<p>
    The scraped books will be saved to the database via the <code>bookRepository.saveAll(books)</code> method.
</p>
