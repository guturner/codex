import * as React from "react"
import { Link } from "gatsby"

import Layout from "../components/layout"
import Seo from "../components/seo"
import * as styles from "../components/index.module.css"

const IndexPage = () => (
  <Layout>
    <Seo title="Home" />

    <div className={styles.textCenter}>
      <h1>
        Hello, world!
      </h1>
    </div>

  </Layout>
)

export default IndexPage
