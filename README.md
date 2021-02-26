<!--
*** I'm using markdown "reference style" links for readability.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/nkuppala
[![LinkedIn][linkedin-shield]][linkedin-url]

# CVLibrary
Test Automation Framework for CVLibrary

  <H2>Project Details</H2>
  <ol>
    <li>
      <H3>About The Project</H3>
      <ul>
        <li> Built using Java, Selenium, TestNG and Maven</li>
        <li> Page Object Model</li>
        <li> Data Driven using TestNG DataProvider</li>
        <li> Extent Reports</li>
        <li> Screenshot on Testcase Fail</li>
        <li> Support Multi Browser Testing (Chrome/Firefox)</li>
      </ul>
    </li>
    <li>
      <H3>ToDo / Can be done</H3>
      <ul>
        <li> Parallel Execution</li>
        <li> Data Driven using External Files</li>
        <li> Jenkins Integration</li>
        <li> Mobile Capatability Testing</li>
      </ul>
    </li>
  </ol>
  
  
  ## Framework Structure:
  * POM design pattern
  * Test base class : src/test/java/"BaseTest.java"
  * Testcase class : src/test/java/"FindJobs.java"
  * Element Locators class : src/main/java/PageObjects/"HomePageElements.java"
  * Element Functionality : src/main/java/PageEvents/"HomePageEvents.java"
  * Extent reports will be stored under {"project.dir"}/Reports
  * Screenshots will be stored under {"project.dir"}/Screenshots
  * Browser drivers are stored under {"project.dir"}/drivers
  * RunAs: TestNG Suite or maven clean install/test
