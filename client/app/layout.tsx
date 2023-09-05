import './globals.css'
import type { Metadata } from 'next'
import { Inter } from 'next/font/google'
import { ClerkProvider, UserButton } from '@clerk/nextjs'
import { dark } from '@clerk/themes'

const inter = Inter({ subsets: ['latin'] })

export const metadata: Metadata = {
  title: 'Subject Alpha',
  description: 'THE fucking system of the boys'
}

export default function RootLayout({
  children
}: {
  children: React.ReactNode
}) {
  return (
    <ClerkProvider appearance={{ baseTheme: dark }}>
      <html lang="en">
        <body className={inter.className}>
          <header className="flex justify-end m-10">
            <UserButton afterSignOutUrl="/" />
          </header>
          {children}
        </body>
      </html>
    </ClerkProvider>
  )
}
